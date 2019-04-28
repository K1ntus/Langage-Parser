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


	public IntermediateCode generateIntermediateCodeList() {
		if(this.size() == 0) {
			return new ExpStm(new Const(0));	//statement sans effet p.185
		}
		if (this.size() > 1) {
			Node tmp = this.get(0);
			this.elts.remove(0);
			
			IntermediateCode left = tmp.generateIntermediateCode();
			
			if(left instanceof Exp)
				left = new ExpStm((Exp) left);
			
			System.out.println("CodeList: left@" + left + ", right@" + this.generateIntermediateCodeList());
			if(!(this.generateIntermediateCodeList() instanceof Stm)){
				return new Seq((Stm)left,new ExpStm((Exp)this.generateIntermediateCodeList()));
			}
			return new Seq((Stm)left,(Stm)this.generateIntermediateCodeList());
		} else if (this.size() == 1) {
			Node tmp = this.get(0);
			this.elts.remove(0);
			IntermediateCode left = tmp.generateIntermediateCode();
			if(left instanceof Exp)
				left = new ExpStm((Exp) left);
			return left;
			
		}
		return new ExpStm(new Const(0));
	}
}
