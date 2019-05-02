package fr.c12.compilator.converter.code;

import java.util.ArrayList;

import fr.c12.compilator.converter.AssemblyTable;

public class CodeHalt extends Code {
    public CodeHalt () {
	super ();
    }

    public ArrayList<String> assemble (AssemblyTable at) {
        ArrayList<String> s = new ArrayList<String> ();
	s.add ("halt");
	return s;
    }

    public String toString () {
	return ("halt");
    }
}
