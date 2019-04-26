package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;

public final class NodeReturn extends NodeExp {

	public NodeReturn(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeReturn clone() {
		return new NodeReturn((Node) get(0).clone());
	}


	public IntermediateCode generateIntermediateCodeReturn() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		return null;
		
	}
}
