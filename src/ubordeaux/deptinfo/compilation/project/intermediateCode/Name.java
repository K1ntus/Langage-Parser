package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeIdent;
import fr.c12.compilator.converter.code.CodeList;

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
	public Code linearize(CodeList cl) {
		return (new CodeIdent (label.toString()));
	}
}
