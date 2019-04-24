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

	
	public Cjump generateIntermediateCodeIf() {
		LabelLocation iftrue = new LabelLocation();
		LabelLocation ifFalse= new LabelLocation();
		int i;
		Exp e1, e2;
		if(this.getExpNode() instanceof NodeRel) {	// cas de comparaison entre 2 objects 
			System.out.println("NodeIf évalué correctement");
			i = ((NodeRel)this.getExpNode()).getCodeOp(); //valeur du symbol de la relation
			e1 = (Exp)((NodeRel)this.getExpNode()).generateIntermediateCodeRel();	//genere une erreure null pointer, verifier getExpNode()
			e2 = (Exp)((NodeRel)this.getExpNode()).generateIntermediateCodeRel();
			return new Cjump(i, e1, e2,iftrue,ifFalse);
		}else{
			i = -1;	//cas d'erreur...
		}
		System.out.println("NodeIf non évalué correctement");
		return new Cjump(i, null, null, iftrue,ifFalse);	//cas erreur, surement buge
	}
}
