package fr.c12.compilator.converter.code;

import java.util.ArrayList;

import fr.c12.compilator.converter.AssemblyTable;

public class CodeNop extends Code {
    public CodeNop () {
	super ();
    }

    public ArrayList<String> assemble (AssemblyTable at) {
        ArrayList<String> s = new ArrayList<String> ();
	s.add ("nop");
	return s;
    }

    public String toString () {
	return ("nop");
    }
}
