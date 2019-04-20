package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;
import ubordeaux.deptinfo.compilation.project.type.Type;

public abstract class NodeExp extends Node {

	protected Type type;

	public NodeExp(Node... abstTrees) {
		super(abstTrees);
	}

	public Type getType() {
		return this.type;
	}

	
	public ExpList generateIntermediateCodeExp() {
		//System.err.println("NodeExp code intermediaire: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		if(this.size()>0){
			NodeExp tmp = (NodeExp) this.get(0);
			this.pop(this.get(0));
			return new ExpList((Exp)tmp.generateIntermediateCode(), this.generateIntermediateCodeExp());	//appel gauche qui retourne une classe fille de exp à cast
																											//appel droit avec le reste de la liste
			//faire NodeOp, NodeCallFct, NodeLiteral pour pouvoir appeler le membre de gauche
		}
		return new ExpList(null,null);
		
		
	}


}
