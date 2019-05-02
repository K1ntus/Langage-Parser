package ubordeaux.deptinfo.compilation.project.node;


import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.type.TypeBoolean;

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

	public Seq generateIntermediateCode() {

		LabelLocation debut = new LabelLocation();
		LabelLocation suite = new LabelLocation();
		LabelLocation sortie = new LabelLocation();
		
		/*
		if((this.getExp()).getClass().toString() == "class ubordeaux.deptinfo.compilation.project.node.NodeOp") {
			switch(((NodeRel)this.getExp()).getName()) {
			case "==":
				i = 14;
			case "!=":
				i =  15;
			case "<":
				i =  10;
			case ">":
				i =  12;
			case "<=":
				i =  11;
			case ">=":
				i =  13;
			case "!<":
				i =  13;
			case "!<=":
				i =  12;
			case "!>":
				i =  8;
			case "!>=":
				i =  9;
			default:
				i = 0;
			}
		}*/
		int i = -1;
		NodeRel rel = null;
		if (this.getExp() instanceof NodeRel) {
			i = ((NodeRel)this.getExp()).getCodeOp();
			rel = ((NodeRel)this.getExp()).clone();
			
        }else {
        	NodeLiteral t = new NodeLiteral(new TypeBoolean(), true);//"true"
        	rel = new NodeRel("eq", this.getExp(), t);
        	i = 14;
        }

		//ce noeud Seq du code interm doit etre modifie sur le stm de gauche
		
		Seq s = new Seq(
				new Label(debut), 
				new Seq(new Cjump(i,(Exp)rel.getOp1().generateIntermediateCode(),(Exp)rel.getOp2().generateIntermediateCode(), suite, sortie),
						new Seq(new Label(suite),
								new Seq((Stm) this.getStm().generateIntermediateCode(), new Seq(new Jump(debut), new Label(sortie))))));
	System.out.println(s.toString());
	return s;
	}
	
}
