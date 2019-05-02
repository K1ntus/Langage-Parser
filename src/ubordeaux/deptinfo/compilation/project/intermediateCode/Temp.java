package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

public class Temp extends Exp {
	private TempValue temp;

	public Temp(TempValue temp) {
		super();
		this.temp = temp;
	}
	
	@Override
	public String toString(){
		return "EXP("+ temp.toString() + ")";
	}

	@Override
	public Code linearize(CodeList cl) {
		// TODO Auto-generated method stub
		return null;
	}


}
