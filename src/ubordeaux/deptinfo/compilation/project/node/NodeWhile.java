package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Cjump;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Jump;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Label;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Seq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;
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
	
	/*
	 * (non-Javadoc)
	 * @see ubordeaux.deptinfo.compilation.project.node.Node#generateIntermediateCode()
	 * Generation du code intermediaire d un NodeWhile represente par un sequent
	 * Ressemble au principe du NodeIf, excepte qu ici on ne gere pas les then
	 */
	public Seq generateIntermediateCode() {

		LabelLocation debut = new LabelLocation();
		LabelLocation suite = new LabelLocation();
		LabelLocation sortie = new LabelLocation();

		int i = -1;
		NodeRel rel = null;
		if (this.getExp() instanceof NodeRel) {//if the expression is relation we just have to get the operation
			i = ((NodeRel)this.getExp()).getCodeOp();
			rel = ((NodeRel)this.getExp()).clone();
			
        }else {									//else this is just an expression, we build a new NodeRel wich represent a relation "exp == true"
        	NodeLiteral t = new NodeLiteral(new TypeBoolean(), true);//"true"
        	rel = new NodeRel("eq", this.getExp(), t);
        	i = 14;
        }
		
		//we build the while loop in intermediate code
		Seq s = new Seq(
				new Label(debut), 
				new Seq(new Cjump(i,(Exp)rel.getOp1().generateIntermediateCode(),(Exp)rel.getOp2().generateIntermediateCode(), suite, sortie),
						new Seq(new Label(suite),
								new Seq((Stm) this.getStm().generateIntermediateCode(), new Seq(new Jump(debut), new Label(sortie))))));
	return s;
	}

	
}
