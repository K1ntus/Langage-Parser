package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

public class Mem extends Exp {
	private Exp exp;

	public Mem(Exp exp) {
		super();
		this.exp = exp;
	}
	
	@Override
	public String toString(){
		if(exp == null) {
			System.out.println("Mem: exp is null");
		}
		return "MEM("+ exp.toString() + ")";
	}

	@Override
	public Code linearize(CodeList cl) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
