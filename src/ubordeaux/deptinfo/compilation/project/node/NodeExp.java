package ubordeaux.deptinfo.compilation.project.node;


import java.util.ArrayList;
import java.util.List;

import ubordeaux.deptinfo.compilation.project.type.Type;

public abstract class NodeExp extends Node {

	protected Type type;

	public NodeExp(Node... abstTrees) {
		super(abstTrees);
	}

	public Type getType() {
		return this.type;
	}
	
	public List<Type> getTypeList() {
		ArrayList<Type> res = new ArrayList<>();
		ArrayList<Node> arr = new ArrayList<>(this.getList());
		for(Node n : arr) {
			System.out.println("Expr->Tuple: " + n.toDotNodeName());
			NodeExp current = (NodeExp) n;
			res.add(current.getType());
		}
		
		return res;		
	}
	
	
	public NodeExp getExp(int i) {
		return ((NodeExp) this.get(i));
	}
	/*
	 public Exp generateIntermediateCode() {
		Exp resBis = null;
		resBis = (Exp)this.generateIntermediateCode();
		return resBis;
		 
  
	 }
	 */
}
