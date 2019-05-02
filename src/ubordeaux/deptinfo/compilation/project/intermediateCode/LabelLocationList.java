package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

public class LabelLocationList extends IntermediateCode{
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

	@Override
	public void canonicalTransformation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Code linearize(CodeList cl) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
