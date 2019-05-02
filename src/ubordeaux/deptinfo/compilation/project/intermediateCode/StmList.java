package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

public class StmList extends Stm{
	private Stm head;
	private StmList tail;

	public StmList(Stm head, StmList tail) {
		super();
		this.head = head;
		this.tail = tail;
	}
	
	public String toString() {
		return ("StmList(" + head.toString() + ","+ tail.toString() + ")");
	}

	@Override
	public Code linearize(CodeList cl) {
		head.linearize(cl);
		tail.linearize(cl);
		return null;
	}
}
