package ubordeaux.deptinfo.compilation.project.node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ubordeaux.deptinfo.compilation.project.type.Type;


import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Seq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeList extends Node {

	public NodeList(Node stm) {
		super(stm);
	}

	public NodeList() {
		super();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		boolean result = true;
		for (Node elt : this.elts) {
			if (elt != null && !elt.checksType()) {
				System.out.println("- Checktype invalid: ");
				System.out.println("- elem:" + elt.toString());
				//System.out.println("* Checktype invalid.");
				result = false;
				break;
			}
		}
		System.out.println("- NodeList well typed");
		return result;
	}

	public Iterator<Node> iterator() {
		return this.elts.iterator();
	}
	

	public int size() {
		return this.elts.size();
	}

	public List<Type> getTypeList(){
		ArrayList<Type> res = new ArrayList<>();
		for(Node n : elts) {
			if(n instanceof NodeExp) {
				NodeExp n_exp = (NodeExp) n;
				res.add(n_exp.getType());
			}
		}
		return res;
	}
	public List<Node> getList(){
		return this.elts;
	}
	

	@Override
	public NodeList clone() {
		NodeList node = new NodeList();
		for (Node elt : this.elts) {
			node.add((Node) elt.clone());
		}
		return node;
	}


	public Stm generateIntermediateCodeList() {
		Node tmp = this.get(0);
		Stm stat = null;
		if(tmp instanceof NodeAssign) {
			System.out.println("IS THIS NODE ASSIGN" );
			stat = (Stm)((NodeAssign)tmp).generateIntermediateCodeAssign();
		}else if (tmp instanceof NodeIf){
			stat = (Stm)((NodeIf)tmp).generateIntermediateCodeIf();
		}

		if (this.size() > 1 && this.get(0) != null) {
			System.out.println("SIZE : " + this.size());
			this.elts.remove(0);
			System.out.println("SIZE : " + this.size());

			return new Seq(stat,this.generateIntermediateCodeList());
		}
		System.out.println("NO IF : Q_Q" );
		System.out.println("TMP IS : " +  tmp);
		System.out.println("STAT IS : " +  stat);

		return stat;
	}
}
