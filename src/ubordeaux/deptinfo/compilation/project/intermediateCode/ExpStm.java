package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

public class ExpStm extends Stm {
	
	private Exp e;
	
	public ExpStm(Exp e){
		super();
		this.e = e;
	}
	
	public Exp getE(){
		return this.e;
	}
	
	@Override
	public String toString(){
		return "EXP("+ e.toString() + ")";
	}

	@Override
	public Code linearize(CodeList cl) {
		// TODO Auto-generated method stub
		return null;
	}


}
