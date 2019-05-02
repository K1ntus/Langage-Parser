package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Cjump;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Jump;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Label;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Seq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;

public final class NodeCase extends Node {

	private String nameValue;
	private boolean defaultValue;
	
	public NodeCase(String nameValue, Node stm) {
		super(stm);
		this.nameValue = nameValue;
		this.defaultValue = false;
	}

	public NodeCase(Node stm) {
		this(null, stm);
		this.defaultValue = true;
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeCase clone() {
		return new NodeCase(nameValue, (Node) this.getStm().clone());
	}

	private Node getStm() {
		return super.get(0);
	}
	
	private String getNameValue() {
		return this.nameValue;
	}

	public boolean isDefaultValue() {
		return defaultValue;
	}

	public IntermediateCode generateIntermediateCodeCase(NodeExp e, LabelLocation l) {
		
		if(!defaultValue) {
			LabelLocation iftrue = new LabelLocation();
	        LabelLocation ifFalse= new LabelLocation();
	        
	        Label l1 = new Label(iftrue);
	        Label l2 = new Label(ifFalse);	        
	        
	        NodeId  n = new NodeId(this.getNameValue(), e.getType());
	        NodeRel rel = new NodeRel("==",e,n) ;
	        Binop b = rel.generateIntermediateCode();
	        
			Cjump c = new Cjump(b.getBinop(), b.getLeft(), b.getRight(), iftrue, ifFalse);    //cas erreur, surement buge
	    	
			Seq s = new Seq(c, 
	    				new Seq(l1,
	    						new Seq((Stm)this.getStm().generateIntermediateCode(), new Seq(new Jump(l),l2))));
			
	    	return s;
		}else {
			return new Seq((Stm)this.getStm().generateIntermediateCode(), (Stm)(new Label(l)));
		}	
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		// TODO Auto-generated method stub
		System.err.println("errr!");
		return null;
	}

}
