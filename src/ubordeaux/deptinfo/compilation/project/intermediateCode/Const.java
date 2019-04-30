package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Const extends Exp {
	private int value;

	public Const(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return "CONST:" + value;
	}

	@Override
	public String toy86() {
		System.out.println("TODO: Const (y86)");
		// TODO Auto-generated method stub
		return null;
	}

}
