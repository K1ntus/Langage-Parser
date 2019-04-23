package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Eseq extends Exp {
	private Stm stm;
	private Exp exp;
	
	public Stm getStm() {
		return stm;
	}

	public Exp getExp() {
		return exp;
	}
	
	public Eseq(Stm stm, Exp exp) {
		super();
		this.stm = stm;
		this.exp = exp;
	}
	
	@Override
	public String toString() {
		return "ESEQ(" + stm.toString() + "," + exp.toString() + ")";
	}

}
