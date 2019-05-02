package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

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

	
	public Seq generateIntermediateCode() {
		
		//System.out.println("in NodeIf 1 ");

        LabelLocation iftrue = new LabelLocation();
        LabelLocation ifFalse= new LabelLocation();
        Label l1 = new Label(iftrue);
        Label l2 = new Label(ifFalse);

        Binop rel = null;
        
        if (this.getExpNode() instanceof NodeRel) {
        	rel = (Binop)((NodeRel)this.getExpNode()).generateIntermediateCode();
        }else {
        	Exp t = new Const(1);//"true"
        	Exp var = (Exp)this.getExpNode().generateIntermediateCode();
        	rel = new Binop(14, var, t);
        }
        
    	Cjump c = new Cjump(rel.getBinop(), rel.getLeft(), rel.getRight(), iftrue, ifFalse);

    	Seq s;
    	if(this.getElseNode() != null) {
    		 s = new Seq(c, 
    			new Seq(l1,
    				new Seq((Stm)((NodeList)this.getThenNode()).generateIntermediateCode(),
    				new Seq(l2,(Stm)((NodeList)this.getElseNode()).generateIntermediateCode()))));
    	}else {
    		 s = new Seq(c, 
        			new Seq(l1,
        				new Seq((Stm)((NodeList)this.getThenNode()).generateIntermediateCode(),
        				l2)));
    	}
    	return s;
    }
}
