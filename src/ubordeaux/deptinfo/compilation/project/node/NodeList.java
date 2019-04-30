package ubordeaux.deptinfo.compilation.project.node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ubordeaux.deptinfo.compilation.project.type.Type;
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
	
	public ExpList generateIntermediateCodeListArgs() {
		
		if (this.size() > 0) {
			Node head = this.getList().get(0);
				this.elts.remove(0);
				if(this.size() > 0)
					return new ExpList((Exp)head.generateIntermediateCode(), ((NodeList)this).generateIntermediateCodeListArgs());
				else
					return new ExpList((Exp)head.generateIntermediateCode(), null);
		}
		return new ExpList((Exp) this.generateIntermediateCode(), null);

		
		
	}


	public Stm generateIntermediateCodeList() {

		Node clone = this.clone();
		//Vieux code, genere bien le seq
		Node tmp = clone.get(0);
		IntermediateCode stat = tmp.generateIntermediateCode();
		
		if(stat instanceof Exp)
			stat = new ExpStm((Exp) stat);
	
		if (clone.size() > 1 && clone.get(0) != null) {
			clone.elts.remove(0);
			
			return new Seq((Stm)stat,(Stm)clone.generateIntermediateCode());
			
			//return new Seq((Stm)stat,(Stm)((NodeList)clone).generateIntermediateCodeList());
		}
				
		return (Stm) stat;
	}
}
