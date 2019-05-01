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
		return "CALL(" + func.toString() + "," + args.toString() + ")";
	}

	public Code linearize(CodeList cl) {
		ArrayList<CodeIdent> args_array = new ArrayList<>();
		
		args_array.add(new CodeIdent(args.getHead().toString()));
		//for()

		CodeCall res = new CodeCall(func.toString(), args_array);
		cl.add(res);
		return res;
		
		//cl.add(new CodeCall(func.linearize(cl), args.linearize(cl)));
	}


}
