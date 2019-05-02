package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

public class Seq extends Stm {
	private Stm left, right;

	public Seq(Stm left, Stm right) {
		super();
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString(){
		//System.out.println(left.toString());
		return "SEQ("+ left.toString() + "," + right.toString() + ")";
	}
	
	
	public Stm getRight() {
		return right;
	}
	
	public Stm getLeft() {
		return left;
	}

	@Override
	public Code linearize(CodeList cl) {
		left.linearize(cl);
		right.linearize(cl);
		
		return null;
	}
	

}
