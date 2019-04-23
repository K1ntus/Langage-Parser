package ubordeaux.deptinfo.compilation.project.node;


import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;

import java.util.ArrayList;
import java.util.List;

import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeTuple;

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
	
	
	public ExpList generateIntermediateCodeExp() {
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		return null;
		//System.err.println("NodeExp code intermediaire: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		/*
		if(this.size()>0){
			NodeExp tmp = (NodeExp) this.get(0);
			this.pop(this.get(0));
			return new ExpList((Exp)tmp.generateIntermediateCode(), this.generateIntermediateCodeExp());	//appel gauche qui retourne une classe fille de exp à cast
																											//appel droit avec le reste de la liste
			//faire NodeOp, NodeCallFct, NodeLiteral pour pouvoir appeler le membre de gauche
		}
		return new ExpList(null,null);
		*/
		//return null;
		
	}
	
}
