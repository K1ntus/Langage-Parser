package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
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


	public IntermediateCode generateIntermediateCode() {// p.186, 174		
		Temp tmp = new Temp(new TempValue());	//Mettre vers celui qui a call la fct
		Node n = this.get(0);
		Move res = new Move(tmp, (Exp) n.generateIntermediateCode());
		
		return res;
	}
}
