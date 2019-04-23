package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Binop extends Exp {
	private int binop;
	private Exp left, right;

	public Binop(int b, Exp l, Exp r) {
		super();
		binop = b;
		left = l;
		right = r;
	}

	public final static int PLUS = 0, MINUS = 1, MUL = 2, DIV = 3, AND = 4, OR = 5, LSHIFT = 6, RSHIFT = 7, ARSHIFT = 8, XOR = 9, LESST = 10, LESSE = 11, GREAT = 12, GREAE = 13, EQUAL = 14, NONEQ = 15;

	public String toString() {
		String result = new String();
		return result;
	}

}
