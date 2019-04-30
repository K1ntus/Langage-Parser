package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class Name extends Exp {
	private LabelLocation label;

	public Name(LabelLocation label) {
		super();
		this.label = label;
	}
	
	public LabelLocation getLocation() {
		return this.label;
	}
	
	@Override
	public String toString(){
		return "NAME("+ label.toString() + ")";
	}
	
	@Override
	public String toy86() {
		return "";
	}
	

}
