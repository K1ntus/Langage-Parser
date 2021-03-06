package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;

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

	public IntermediateCode generateIntermediateCode() {//we just use remember a single label for NodeCaseList and the expression to compare
		LabelLocation l = new LabelLocation();
		return ((NodeCaseList)this.getStm()).generateIntermediateCode((NodeExp) this.getExp(), l);	
	}

}
