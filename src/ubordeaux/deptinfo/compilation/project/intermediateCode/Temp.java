package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Temp extends Exp {
	private TempValue temp;

	public Temp(TempValue temp) {
		super();
		this.temp = temp;
	}
	
	@Override
	public String toString(){
		return "EXP("+ temp.toString() + ")";
	}


	@Override
	public String toy86() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
