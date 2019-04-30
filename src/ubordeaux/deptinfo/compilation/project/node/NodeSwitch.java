package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;

public final class NodeSwitch extends Node {
	
	Node casel;

	public NodeSwitch(Node e, Node stm) {
		super(e, stm);
		this.casel = stm;
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeSwitch clone() {
		return new NodeSwitch((Node) this.getExp().clone(), (Node) this.getStm().clone());
	}

	private Node getStm() {
		return this.get(1);
	}

	private Node getExp() {
		return this.get(0);
	}

	public IntermediateCode generateIntermediateCodeSwitch() {
		//System.out.println("Size node : "+this.size());
		//System.out.println("Statement switch : "+this.getStm() + " Sise of stm(Caslist) is : " + this.getStm().size());
		//System.out.println("Statement switch : "+this.casel + " Sise of stm(Caslist) is : " + this.casel.size());

		//System.out.println("Expression switch : "+this.getExp());
		
		//Cjump c = new Cj
		
		//Seq s = new Seq(
		
		IntermediateCode c = ((NodeCaseList)this.getStm()).generateIntermediateCodeCaseList((NodeExp) this.getExp());
		//System.out.println("Code inter switch :"+c);
		return c;
		
		
	}
}
