package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

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
		if(this.tail != null && this.head != null)
			return this.head.toString() + this.tail.toString();
		else if(this.head != null)
			return this.head.toString();
		return "Explist(null,null)";
	}

	public Code linearize(CodeList cl) {
		head.linearize(cl);
		tail.linearize(cl);
		return cl;
	}

}
