package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

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

	public ExpList generateIntermediateCodeCase() {
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		return null;
		
		
		//IntermediateCode i =  this.getStm().generateIntermediateCode();
		//ExpList l = new ExpList(this.getStm(),this.pop(this.getStm()).generateIntermediateCodeCase(this.getNameValue,this.getStm()));
		//return (ExpList) i; //a modifier... T.T	
	}
}
