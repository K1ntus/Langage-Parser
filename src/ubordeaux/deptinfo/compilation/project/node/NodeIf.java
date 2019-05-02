package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Cjump;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Label;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Seq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;

public final class NodeIf extends Node {

	public NodeIf(Node boolExp, Node stm) {
		super(boolExp, stm);
	}

	public NodeIf(Node e, Node stm1, Node stm2) {
		super(e, stm1, stm2);
	}

	
	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeIf clone() {
		Node expNode = this.getExpNode();
		Node thenNode = this.getThenNode();
		Node elseNode = this.getElseNode();
		if (elseNode == null)
			return new NodeIf((Node) expNode.clone(), (Node) thenNode.clone());
		else
			return new NodeIf((Node) expNode, (Node) thenNode.clone(), (Node) elseNode.clone());
	}

	private Node getExpNode() {
		return this.get(0);
	}
	

	private Node getElseNode() {
		if (this.size() == 3)
			return this.get(2);
		else
			return null;
	}

	private Node getThenNode() {
		return this.get(1);
	}

	
	/*
	 * (non-Javadoc)
	 * @see ubordeaux.deptinfo.compilation.project.node.Node#generateIntermediateCode()
	 * Génère le code intermediaire d'un NodeIf représenté sous la forme d un sequent
	*/
	public Seq generateIntermediateCode() {
		

        LabelLocation iftrue = new LabelLocation();
        LabelLocation ifFalse= new LabelLocation();
        Label l1 = new Label(iftrue);//label at the start of statements
        Label l2 = new Label(ifFalse);//label to jump over those statement

        Binop rel = null;
        
        if (this.getExpNode() instanceof NodeRel) {//if the Exp is a relation, there is no preblem to make Binop
        	rel = (Binop)((NodeRel)this.getExpNode()).generateIntermediateCode();
        }else {
        	Exp t = new Const(1);//"true"
        	Exp var = (Exp)this.getExpNode().generateIntermediateCode();//we have to simulate a Binop by adding "== true"
        	rel = new Binop(14, var, t);
        }
        
    	Cjump c = new Cjump(rel.getBinop(), rel.getLeft(), rel.getRight(), iftrue, ifFalse);	//CJUMP of the if

    	Seq s;
    	if(this.getElseNode() != null) {// when there is no else statement
    		 s = new Seq(c, 
    			new Seq(l1,																		//building of if in intermediate code with Seq and labels
    				new Seq((Stm)((NodeList)this.getThenNode()).generateIntermediateCode(),
    				new Seq(l2,(Stm)((NodeList)this.getElseNode()).generateIntermediateCode()))));
    	}else {//only if withou else
    		 s = new Seq(c, 
        			new Seq(l1,
        				new Seq((Stm)((NodeList)this.getThenNode()).generateIntermediateCode(), //building of if in intermediate code with Seq and labels
        				l2)));
    	}
    	return s;
}

}
