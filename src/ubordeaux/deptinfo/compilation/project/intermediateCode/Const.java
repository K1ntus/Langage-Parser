package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeConstInt;
import fr.c12.compilator.converter.code.CodeList;

public class Const extends Exp {
	private int value;

	public Const(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "CONST:" + value;
	}

	@Override
	public Code linearize(CodeList cl) {
		return (new CodeConstInt (value));
	}

}
