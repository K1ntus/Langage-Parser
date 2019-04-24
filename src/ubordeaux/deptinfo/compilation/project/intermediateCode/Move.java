package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Move extends Stm {
	private Exp dst, src;

	public Move(Exp dst, Exp src) {
		super();
		this.dst = dst;
		this.src = src;
	}
	
	public String toString() {
		if(dst == null) {
			return "Move: dest is null";
		}
		if(src == null) {
			return "Move: src is null";
		}
		return "Move(" + dst.toString() + "," + src.toString() + ")";
	}
}
