package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;

public final class NodeDispose extends Node {

	public NodeDispose(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeDispose clone() {
		return new NodeDispose((Node) this.get(0).clone());
	}


	public IntermediateCode generateIntermediateCodeDispose() {
		System.err.println("* FREE("+this+") - Todo");
		return new Move(new Mem( (Exp) this.get(0).generateIntermediateCode() ),new Name( new LabelLocation("null")));
	}
}
