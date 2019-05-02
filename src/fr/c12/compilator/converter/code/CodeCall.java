package fr.c12.compilator.converter.code;

import java.util.ArrayList;
import java.util.List;

import fr.c12.compilator.converter.AssemblyTable;

public class CodeCall extends Code{
	private String funct_name;
	private List<CodeIdent> args;
	
	private CodeCall() {
		args = new ArrayList<>();
	}
	public CodeCall(String func_label, CodeIdent ... args ) {
		this();
		this.funct_name = func_label;
		
	}
	public CodeCall(String func_label, List<CodeIdent> args ) {
		this.args = args;
		this.funct_name = func_label;
		
	}
	

    public ArrayList<String> assemble (AssemblyTable at) {
    	//System.out.println("CodeCall: " + this);
		ArrayList<String> as = new ArrayList<String> ();
		
		boolean hasSave = false;
		int rdst = at.registerGive(null, null);
		if (rdst == -1) {
			rdst = 0;
			as.add("\tpushl " + at.registerName(rdst));
			hasSave = true;
		}
		
		for(CodeIdent elt : args) {
			as.add("\rmrmovl " + elt.getLabel() + ", " + at.registerName(rdst));
		    as.add("\tpushl " + at.registerName(rdst));
		}
		
		as.add("\tcall " + funct_name);
		
		if (hasSave) {
			as.add("\tpopl " + at.registerName(rdst));
		}
		return as;
    }

	@Override
	public String toString() {
		return "code call to: " + this.funct_name + ", args: " + this.args;
	}

}
