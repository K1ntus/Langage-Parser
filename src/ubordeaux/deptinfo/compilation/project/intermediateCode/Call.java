package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Call extends Exp {
	private Exp func;
	private ExpList args;

	public Call(Exp func, ExpList args) {
		super();
		this.func = func;
		this.args = args;
	}
	
	@Override
	public String toString() {
		System.out.println("BUG HAPPER NOW ! "+func + "  " + args);
		return "CALL(" + func.toString() + "," + args.toString() + ")";
	}


	@Override
	public String toy86() {
		// TODO Auto-generated method stub
		return null;
	}

}
