package fr.c12.compilator.converter.code;

import java.util.ArrayList;

import fr.c12.compilator.converter.AssemblyTable;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;

public class CodeAssignOpBinary extends Code {
    public int    op;
    public CodeIdent dst;
    public Code      srcl;
    public Code      srcr;

    public CodeAssignOpBinary (CodeIdent d, int op, Code l, Code r) {
	super ();
	this.op   = op;
	this.dst  = d;
	this.srcl = l;
	this.srcr = r;
    }

    public ArrayList<String> assemble (AssemblyTable at) {
	ArrayList<String> as = new ArrayList<String> ();
	int rdst;

	CodeIdent isrcl = null;
	CodeIdent isrcr = null;
	int rsrcl = -1;
	int rsrcr = -1;
	if (srcl instanceof CodeIdent) {
	    isrcl = (CodeIdent) srcl;
	    rsrcl = at.registerFind (isrcl);
	}
	if (srcr instanceof CodeIdent) {
	    isrcr = (CodeIdent) srcr;
	    rsrcr = at.registerFind (isrcr);
	}

	if (op == Binop.MUL) {
	    if (rsrcl == -1) {
		rsrcl = at.registerGive (dst, isrcr);
		as.addAll (at.registerLoad (rsrcl, srcl));
	    }
	    as.add ("\tpushl " + at.registerName (rsrcl));
	    if ((isrcl != null) && isrcl.isTemp ())
		at.registerRelease (isrcl);

	    if (rsrcr == -1) {
		rsrcr = at.registerGive (dst, isrcl);
		as.addAll (at.registerLoad (rsrcr, srcr));
	    }
	    as.add ("\tpushl " + at.registerName (rsrcr));
	    if ((isrcr != null) && isrcr.isTemp ())
		at.registerRelease (isrcr);

	    as.addAll (at.registerCallerPurge ());
	    as.add ("\tcall mult");
	    as.add ("\tiaddl 8,%esp");
	    rdst = 0;
	    at.registerSet (rdst, dst);
	}else if (op == Binop.DIV) {
	    if (rsrcl == -1) {
		rsrcl = at.registerGive (dst, isrcr);
		as.addAll (at.registerLoad (rsrcl, srcl));
	    }
	    as.add ("\tpushl " + at.registerName (rsrcl));
	    if ((isrcl != null) && isrcl.isTemp ())
		at.registerRelease (isrcl);

	    if (rsrcr == -1) {
		rsrcr = at.registerGive (dst, isrcl);
		as.addAll (at.registerLoad (rsrcr, srcr));
	    }
	    as.add ("\tpushl " + at.registerName (rsrcr));
	    if ((isrcr != null) && isrcr.isTemp ())
		at.registerRelease (isrcr);

	    as.addAll (at.registerCallerPurge ());
	    as.add ("\tcall div");
	    as.add ("\tiaddl 8,%esp");
	    rdst = 0;
	    at.registerSet (rdst, dst);
	}
	else {
	    if (rsrcl != -1) {
		rdst = rsrcl;
		at.registerSet (rdst, dst);
	    }
	    else {
		rdst = at.registerFind (dst);
		if (rdst == -1)
		    rdst = at.registerGive (dst, isrcl, isrcr);
		as.addAll (at.registerLoad (rdst, srcl));
	    }

	    String sop = "";
	    if (op == Binop.PLUS)
		sop = "addl";
	    else if (op == Binop.MINUS)
		sop = "subl";

	    if (srcr instanceof CodeConstInt)
		as.add ("\ti" + sop + " " + srcr.toString () + "," + at.registerName (rdst));
	    else {
		if (rsrcr == -1) {
		    rsrcr = at.registerGive (dst, isrcl);
		    as.addAll (at.registerLoad (rsrcr, srcr));
		}
		as.add ("\t" + sop + " " + at.registerName (rsrcr) + "," + at.registerName (rdst));
	    }

	    if ((isrcl != null) && isrcl.isTemp ())
		at.registerRelease (isrcl);
	    if ((isrcr != null) && isrcr.isTemp ())
		at.registerRelease (isrcr);
	}

	if (! dst.isTemp ()) {
	    at.identAdd (dst.getLabel ());
	    as.add ("\trmmovl " + at.registerName (rdst) + "," + dst.getLabel ());
	}

	return as;
    }

    public String toString () {
	return (dst.toString () + " = " + srcl.toString () + " " + op + " " + srcr.toString ());
    }
}
