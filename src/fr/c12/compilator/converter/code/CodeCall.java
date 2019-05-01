package fr.c12.compilator.converter.code;

import java.util.ArrayList;
import java.util.List;

import fr.c12.compilator.converter.AssemblyTable;

public class CodeCall extends Code{
	private String funct_name;
	private List<CodeIdent> elts;
	
	private CodeCall() {
		this.elts = new ArrayList<CodeIdent>();
		
	}
	public CodeCall(String func_label, CodeIdent ... args ) {
		this();
		for (CodeIdent elt : args) {
			elts.add(elt);
		}
		this.funct_name = func_label;
		
	}
	public CodeCall(String func_label, List<CodeIdent> args ) {
		elts = args;
		this.funct_name = func_label;
		
	}
	

    public ArrayList<String> assemble (AssemblyTable at) {
		ArrayList<String> as = new ArrayList<String> ();
		for(CodeIdent elt : elts) {
			int rdst;
			
			CodeIdent isrc = null;
			
		    rdst = at.registerFind (elt);
		    if (rdst == -1)
		    	rdst = at.registerGive (elt, isrc, null);
		    as.add("\tpushl"+isrc.getLabel());
		    
		    //as.addAll (at.registerLoad (rdst, src));
		    
		    
		}
		
		as.add("\tjmp " + funct_name);
		return as;
    }

	@Override
	public String toString() {
		return "code call to: " + this.funct_name + ", args: " + this.elts;
	}

}
