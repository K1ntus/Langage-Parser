package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Mem;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Move;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Name;

public final class NodeNew extends Node {

	public NodeNew(Node exp) {
		super(exp);
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

	
	public IntermediateCode generateIntermediateCode() {
		LabelLocation init = new LabelLocation("null");
		Name name = (Name) this.get(0).generateIntermediateCode();
		return new Move(new Mem(name), new Name(init));
		
	}
}
