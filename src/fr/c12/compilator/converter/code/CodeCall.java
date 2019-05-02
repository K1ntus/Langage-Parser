package fr.c12.compilator.converter.code;

import java.util.ArrayList;
import java.util.List;

import fr.c12.compilator.converter.AssemblyTable;

public class CodeCall extends Code{
	private String funct_name;
	private CodeList args;
	
	private CodeCall() {
		
	}
	public CodeCall(String func_label, CodeIdent ... args ) {
		this();
		this.funct_name = func_label;
		
	}
	public CodeCall(String func_label,CodeList args ) {
		this.args = args;
		this.funct_name = func_label;
		
	}
	

    public ArrayList<String> assemble (AssemblyTable at) {
    	//System.out.println("CodeCall: " + this);
		ArrayList<String> as = new ArrayList<String> ();
		
		
		as.add("\tjmp " + funct_name);
		return as;
    }

	@Override
	public String toString() {
		return "code call to: " + this.funct_name + ", args: " + this.args;
	}

}
