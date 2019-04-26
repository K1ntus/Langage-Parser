package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Move;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Temp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.TempValue;

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


	public IntermediateCode generateIntermediateCodeRet() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		Temp tmp = new Temp(new TempValue());
		
		return new Move(tmp, this.generateIntermediateCodeExp());
		
	}
}
