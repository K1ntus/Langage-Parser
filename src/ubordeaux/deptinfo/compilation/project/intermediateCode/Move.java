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
		System.out.println("dst: " + dst + " - src: " + src);
		
		if(src != null)
			return "MOVE(" + dst.toString() + "," + src.toString() + ")";
		
		return "MOVE(" + dst.toString() + "," + src + ")";
	}

	@Override
	public Code linearize(CodeList cl) {
		Code r = dst.linearize (cl);
		Code l = src.linearize (cl);
		if (! (l instanceof CodeIdent))
		    return (null);
		
		cl.add (new CodeAssign ((CodeIdent) l, r));
		return (l);
	}
}
