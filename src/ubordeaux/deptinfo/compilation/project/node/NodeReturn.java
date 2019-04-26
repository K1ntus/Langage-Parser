package ubordeaux.deptinfo.compilation.project.node;

<<<<<<< HEAD
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
=======
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
>>>>>>> 3e6522c761ad4c548e7835977bd713ce70d44ac7

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
