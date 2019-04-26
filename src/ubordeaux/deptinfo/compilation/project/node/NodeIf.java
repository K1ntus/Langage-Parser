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

	
	public Seq generateIntermediateCodeIf() {
		
		//System.out.println("in NodeIf 1 ");

        LabelLocation iftrue = new LabelLocation();
        LabelLocation ifFalse= new LabelLocation();
        Label l1 = new Label(iftrue);
        Label l2 = new Label(ifFalse);
        		
        int i;
        Exp e1, e2;
        Binop rel = null;
        //if(this.getExpNode() instanceof NodeRel) {    // cas de comparaison entre 2 objects 
        rel = (Binop)((NodeRel)this.getExpNode()).generateIntermediateCode();

            /*
            i = ((NodeRel)this.getExpNode()).getCodeOp(); //valeur du symbol de la relation
            e1 = (Exp)((NodeRel)this.getExpNode()).generateIntermediateCodeRel();    //genere une erreure null pointer, verifier getExpNode()
            e2 = (Exp)((NodeRel)this.getExpNode()).generateIntermediateCodeRel();
            */
        //}else{
          //  i = -1;    //cas d'erreur...
       // }
		//System.out.println("in NodeIf 2 rel is : "+rel);

        /*
        System.out.println("rel is : "+rel.toString());
        
    	
    	System.out.println("__________________________");
    	
    	System.out.println(this.getThenNode() +" become " + ((NodeList)this.getThenNode()).generateIntermediateCodeList());
    	
    	System.out.println("__________________________");

    	//this.getThenNode().generateIntermediateCode().toString();
    	
    	System.out.println("__________________________");
    	
    	*/
    	Cjump c = new Cjump(rel.getBinop(), rel.getLeft(), rel.getRight(), iftrue, ifFalse);    //cas erreur, surement buge
		//System.out.println("in NodeIf 3 ");



    	Seq s = new Seq(c, 
    			new Seq(l1,
    				new Seq((Stm)((NodeList)this.getThenNode()).generateIntermediateCodeList(),
    				l2)));

    	return s;
    }
}
