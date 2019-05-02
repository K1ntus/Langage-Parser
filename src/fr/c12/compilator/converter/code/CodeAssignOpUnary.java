package fr.c12.compilator.converter.code;

import java.util.ArrayList;

import fr.c12.compilator.converter.AssemblyTable;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;

public class CodeAssignOpUnary extends Code {
    public int		 op;
    public CodeIdent dst;
    public Code      src;

    public CodeAssignOpUnary (CodeIdent d, int op, Code s) {
	super ();
	this.op  = op;
	this.dst = d;
	this.src = s;
    }

    public ArrayList<String> assemble (AssemblyTable at) {
	ArrayList<String> as = new ArrayList<String> ();
	int rdst = -1;

	CodeIdent isrc = null;
	int rsrc = -1;
	if (src instanceof CodeIdent) {
	    isrc = (CodeIdent) src;
	    rsrc = at.registerFind (isrc);
	}

	if (op == Binop.PLUS) {
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
	}
	else if (op == Binop.MINUS) {
	    rdst = at.registerFind (dst);
	    if (rdst == -1)
		rdst = at.registerGive (dst, isrc, null);
	    String ndst = at.registerName (rdst);
	    as.add ("\txorl " + ndst + "," + ndst);
	    if (isrc != null) {
		if (rsrc == -1) {
		    rsrc = at.registerGive (isrc, dst, null);
		    as.add ("\tmrmovl " + isrc.getLabel () + "," + at.registerName (rsrc));
		}
		as.add ("\tsubl " + at.registerName (rsrc) + "," + ndst);
	    }
	    else
		as.add ("\tisubl " + src.toString () + "," + ndst);
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
	return (dst.toString () + " = " + op + " " + src.toString ());
    }
}
