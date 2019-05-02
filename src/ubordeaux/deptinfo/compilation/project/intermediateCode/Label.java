package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeLabel;
import fr.c12.compilator.converter.code.CodeList;

public class Label extends Stm {
	private LabelLocation label;

	public Label(LabelLocation label) {
		super();
		this.label = label;
	}
	
	public String toString() {
		return "Label(" + this.label.toString() + ")";
	}

	@Override
	public Code linearize(CodeList cl) {
		return new CodeLabel(label.toString());
	}

}
