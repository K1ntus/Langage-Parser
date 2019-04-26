package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class LabelLocationList {
	private LabelLocation head;
	private LabelLocationList tail;

	public LabelLocationList(LabelLocation head, LabelLocationList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	
	@Override
	public String toString(){
		if(tail != null)
			return head.toString() + "," + tail.toString();
		return head.toString();

	}
	

}
