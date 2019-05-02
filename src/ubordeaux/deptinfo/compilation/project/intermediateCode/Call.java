package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.util.ArrayList;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeCall;
import fr.c12.compilator.converter.code.CodeIdent;
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
		if(args != null)
			return "CALL(" + func.toString() + "," + args.toString() + ")";
		return "CALL(" + func.toString() + ", void )";
	}

	public Code linearize(CodeList cl) {
		
		CodeList args_array = new CodeList();

		CodeCall res = new CodeCall(func.toString(), args_array);
		return res;
	}


}
