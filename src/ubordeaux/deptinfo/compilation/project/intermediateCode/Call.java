package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Call extends Exp {
	private Exp func;
	private ExpList args;

	public Call(Exp func, ExpList args) {
		super();
		this.func = func;
		this.args = args;
	}
	
	public String toString() {
		return "Call(" + this.getClass().toString() + "," + this.args.toString() + ")";
	}

}
