package ubordeaux.deptinfo.compilation.project.intermediateCode;

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
	public String toy86() {

		System.out.println("TODO: Move (y86)");
		// TODO Auto-generated method stub
		return null;
	}
}
