package fr.c12.compilator.converter.code;

import java.util.ArrayList;

import fr.c12.compilator.converter.AssemblyTable;

public class CodeLabel extends Code{
	
	private String name;
	public CodeLabel(String name) {
		this.name = name;
	}

    public ArrayList<String> assemble (AssemblyTable at) {
		ArrayList<String> as = new ArrayList<String> ();
		as.add(name + ":");
		
		return as;
    }
    	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "label: " + name;
	}

}
