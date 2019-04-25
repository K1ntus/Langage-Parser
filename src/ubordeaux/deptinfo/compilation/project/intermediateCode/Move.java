package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Move extends Stm {
	private Exp dst, src;

	public Move(Exp dst, Exp src) {
		super();
		this.dst = dst;
		this.src = src;
	}
	
	public String toString() {
		//System.out.println("Move(" + dst.toString() + "," + src.toString() + ")");
		return "Move(" + dst.toString() + "," + src.toString() + ")";
	}
}
