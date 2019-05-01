package fr.c12.compilator.converter.code;

import java.util.ArrayList;

import fr.c12.compilator.converter.AssemblyTable;

public class CodeAssign extends Code {
    CodeIdent dst;
    Code src;

    public CodeAssign (CodeIdent d, Code s) {
	super ();
	this.dst = d;
	this.src = s;
    }

    public ArrayList<String> assemble (AssemblyTable at) {
	ArrayList<String> as = new ArrayList<String> ();
	int rdst;

	CodeIdent isrc = null;
	int rsrc = -1;
	if (src instanceof CodeIdent) {
	    isrc = (CodeIdent) src;
	    rsrc = at.registerFind (isrc);
	}
	if (rsrc != -1) {
	    rdst = rsrc;
	    at.registerSet (rdst, dst);
	}
	else {
	    rdst = at.registerFind (dst);
	    if (rdst == -1)
		rdst = at.registerGive (dst, isrc, null);
	    as.addAll (at.registerLoad (rdst, src));
	}

	if ((isrc != null) && isrc.isTemp ())
	    at.registerRelease (isrc);
	if (! dst.isTemp ()) {
	    at.identAdd (dst.getLabel ());
	    as.add ("\trmmovl " + at.registerName (rdst) + "," + dst.getLabel ());
	}

	return as;
    }

    public String toString () {
	return (dst.toString () + " = " + src.toString ());
    }
}
