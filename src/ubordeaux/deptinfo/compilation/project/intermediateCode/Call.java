package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

public class Call extends Exp {
	private Exp func;
	private ExpList args;

	public Call(Exp func, ExpList args) {
		super();
		this.func = func;
		this.args = args;
	}
	
	@Override
	public String toString() {
		return "CALL(" + func.toString() + "," + args.toString() + ")";
	}

	@Override
	public Code linearize(CodeList cl) {
		// TODO Auto-generated method stub
		return null;
	}


}
