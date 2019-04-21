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
		// TODO Auto-generated method stub
		return null;
	}

}
