package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;

public final class NodeCaseList extends NodeExp {

	public NodeCaseList() {
		super();
	}

	public NodeCaseList(NodeCase node) {
		super(node);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeCaseList clone() {
		return new NodeCaseList();
	}


	public IntermediateCode generateIntermediateCodeCaseList() {
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		return null;
	}
}
