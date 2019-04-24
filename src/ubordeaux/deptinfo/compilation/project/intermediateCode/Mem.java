package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Mem extends Exp {
	private Exp exp;

	public Mem(Exp exp) {
		super();
		this.exp = exp;
	}
	
	@Override
	public String toString(){
		if(exp == null) {
			System.out.println("Mem: exp is null");
		}
		return "MEM("+ exp.toString() + ")";
	}
	
}
