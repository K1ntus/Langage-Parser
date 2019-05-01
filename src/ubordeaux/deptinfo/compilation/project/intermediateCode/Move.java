package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeAssign;
import fr.c12.compilator.converter.code.CodeIdent;
import fr.c12.compilator.converter.code.CodeList;

public class Move extends Stm {
	private Exp dst, src;

	public Move(Exp dst, Exp src) {
		super();
		this.dst = dst;
		this.src = src;
	}
	
	public String toString() {
		return "MOVE(" + dst.toString() + "," + src.toString() + ")";
	}

	@Override
	public Code linearize(CodeList cl) {
		Code r = dst.linearize (cl);
		Code l = src.linearize (cl);
		if (! (l instanceof CodeIdent))
		    return (null);
		
		//System.out.println("Move - linearized: "+this);

		System.out.println("Left: "+l);
		System.out.println("Right: "+r);
		cl.add (new CodeAssign ((CodeIdent) l, r));
		return (l);
	}
}
