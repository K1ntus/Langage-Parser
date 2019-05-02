package fr.c12.compilator.converter.code;

import java.util.ArrayList;

import fr.c12.compilator.converter.AssemblyTable;

public abstract class Code {
    String label;

    public Code () {
	this.label = null;
    }

    public ArrayList<String> assemble (AssemblyTable at) {
    	return new ArrayList<String> ();
    }

    public boolean equals (Code n) {
    	return false;
    }

    abstract public String toString ();
}
