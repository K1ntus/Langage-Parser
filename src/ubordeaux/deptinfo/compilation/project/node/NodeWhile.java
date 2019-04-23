package ubordeaux.deptinfo.compilation.project.node;


import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeWhile extends Node {

	public NodeWhile(Node boolExpr, Node stm) {
		super(boolExpr, stm);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeWhile clone() {
		return new NodeWhile((Node) this.getExp().clone(), (Node) this.getStm().clone());
	}

	private Node getStm() {
		return this.get(1);
	}

	private Node getExp() {
		return this.get(0);
	}

	public IntermediateCode generateIntermediateCodeWhile() {
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		return null;
		/*
		//i =  null;
		
		LabelLocation debut = new LabelLocation();
		LabelLocation suite = new LabelLocation();
		LabelLocation sortie = new LabelLocation();
		int i = 0;
		if((this.getExp()).getClass().toString() == "class ubordeaux.deptinfo.compilation.project.node.NodeOp") {
			switch(((NodeOp)this.getExp()).getName()) {
			case "==":
				i = 0;
			case "!=":
				i =  1;
			case "<":
				i =  2;
			case ">":
				i =  3;
			case "<=":
				i =  4;
			case ">=":
				i =  5;
			case "!<":
				i =  6;
			case "!<=":
				i =  7;
			case "!>":
				i =  8;
			case "!>=":
				i =  9;
			default:
				i = 0;
			}
		}
		return new Seq(
				new Label(debut), 
				new Seq(new Cjump(i,(Exp)((NodeRel)this.getExp()).getOp1().generateIntermediateCode(),(Exp)((NodeRel)this.getExp()).getOp2().generateIntermediateCode(), suite, sortie),
						new Seq(new Label(suite),
								new Seq((Stm) this.getStm().generateIntermediateCode(), new Seq(new Jump(debut), new Label(sortie))))));
								//ce noeud Seq du code interm doit etre modifie sur le stm de gauche
*/
	}
	
}
