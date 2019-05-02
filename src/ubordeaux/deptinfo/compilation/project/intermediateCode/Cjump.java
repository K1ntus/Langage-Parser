package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeAssignOpBinary;
import fr.c12.compilator.converter.code.CodeLabel;
import fr.c12.compilator.converter.code.CodeList;

public class Cjump extends Stm {
	private int relop;
	private Exp left, right;
	private LabelLocation iftrue, iffalse;

	public Cjump(int relop, Exp left, Exp right, LabelLocation iftrue, LabelLocation iffalse) {
		super();
		this.relop = relop;
		this.left = left;
		this.right = right;
		this.iftrue = iftrue;
		this.iffalse = iffalse;
	}
	
	

	public Exp getLeft() {
		return left;
	}



	public final static int EQ = 0, NE = 1, LT = 2, GT = 3, LE = 4, GE = 5, ULT = 6, ULE = 7, UGT = 8, UGE = 9;

	public static int notRel(int relop) {
		switch (relop) {
		case Binop.EQUAL:
			return Binop.NONEQ;
		case Binop.NONEQ:
			return Binop.EQUAL;
		case Binop.LESST:
			return Binop.GREAE;
		case Binop.GREAE:
			return Binop.LESST;
		case Binop.GREAT:
			return Binop.LESSE;
		case Binop.LESSE:
			return Binop.GREAT;
		case ULT:
			return UGE;
		case UGE:
			return ULT;
		case UGT:
			return ULE;
		case ULE:
			return UGT;
		default:
			throw new Error("bad relop in CJUMP.notRel");
		}
	}

	@Override
    public String toString() {
       // System.out.println("CJUMP("+ relop +","+ left.toString() +","+ right.toString() +","+ iftrue.toString() +","+ iffalse.toString() + ")");
        return "CJUMP("+ relop +","+ left.toString() +","+ right.toString() +","+ iftrue.toString() +","+ iffalse.toString() + ")";
    }



	@Override
	public Code linearize(CodeList cl) {
		//CodeAssignOpBinary exp = new CodeAssignOpBinary(new TempValue(), relop, left.linearize(cl), right.linearize(cl));
		
		//Code exp = new Binop(relop, left, right).linearize(cl);
		cl.add(new CodeLabel(iftrue.toString()));
		cl.add(new CodeLabel(iffalse.toString()));
		
		return null;
	}
}