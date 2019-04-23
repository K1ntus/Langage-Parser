package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class ExpStm extends Stm {
	
	private Exp e;
	
	public ExpStm(Exp e){
		super();
		this.e = e;
	}
	
	public Exp getE(){
		return this.e;
	}
	
	@Override
	public String toString(){
		return "EXP("+ e.toString() + ")";
	}
	
	
}
