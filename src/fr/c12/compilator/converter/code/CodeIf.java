package fr.c12.compilator.converter.code;

import java.util.ArrayList;

import fr.c12.compilator.converter.AssemblyTable;
import ubordeaux.deptinfo.compilation.project.node.Node;

public class CodeIf extends Code {
	Code boolean_expression;
	CodeList if_true, if_false;

	public CodeIf(Code expr, CodeList if_true) {
		this.boolean_expression = expr;
		this.if_true = if_true;
		this.if_false = null;
		
	}
	public CodeIf(Code expr, CodeList if_true, CodeList if_false) {
		this(expr, if_true);
		this.if_false = if_false;		
	}
	 
	 /*
(non-Javadoc)
	 * @see fr.c12.compilator.converter.code.Code#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}


	public ArrayList<String> assemble (AssemblyTable at) {
		ArrayList<String> s = new ArrayList<String> ();
		return s;
	}
}
