package ubordeaux.deptinfo.compilation.project.intermediateCode;

public class ExpList extends IntermediateCode {
	private Exp head;
	private ExpList tail;
	
	public ExpList getTail() {
		return tail;
	}

	public ExpList(Exp head, ExpList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	
	public Exp getHead() {
		return this.head;
	}
	

	@Override
	public void canonicalTransformation() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".canonicalTransformation()()");
	}

	@Override
	public String toString() {
		if(this.tail != null && this.head != null) {
			System.out.println("tail and head not null");
			return this.head.toString() + this.tail.toString();
		}
		else if(this.head != null) {
			System.out.println("head not null");
			return this.head.toString();
		}
		return "Explist(null,null)";
	}
	
	@Override
	public String toy86() {
		return "";
	}

}
