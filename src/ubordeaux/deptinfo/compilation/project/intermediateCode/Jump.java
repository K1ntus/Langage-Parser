package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

public class Jump extends Stm {
	public Exp exp;
	public LabelLocationList targets;

	public Jump(Exp exp, LabelLocationList targets) {
		super();
		this.exp = exp;
		this.targets = targets;
	}

	public Jump(LabelLocation target) {
		this(new Name(target), new LabelLocationList(target, null));
	}
	
	@Override
	public String toString(){
		return "JUMP("+ exp.toString() + "," + targets.toString() + ")";
	}

	public String toy86() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Code linearize(CodeList cl) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
