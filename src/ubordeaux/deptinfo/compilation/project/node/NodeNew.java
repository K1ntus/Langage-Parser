package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;

public final class NodeNew extends Node {

	public NodeNew(Node stm) {
		super(stm);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeNew clone() {
		return new NodeNew((Node) this.get(0).clone());
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		return null;
		
	}
}
