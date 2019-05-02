package fr.c12.compilator.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeIdent;

public class AssemblyTable {
    private static String   regname[] = { "eax", "ecx", "edx", "ebx", "esi", "edi", "ebp" };
    private CodeIdent       regused[];
    private boolean         regdrty[];
    private HashSet<String> dataset;

    public AssemblyTable () {
	this.regused = new CodeIdent[7];
	this.regdrty = new boolean[7];
	this.dataset = new HashSet<String> ();
    }

    public String registerName (int i) {
	return ("%" + regname[i]);
    }

    public int registerFind (CodeIdent id) {
	for (int i = 0; i < 7; i ++) {
	    if ((regused[i] != null) && (regused[i].equals (id)))
		return i;
	}
	return -1;
    }

    public void registerSet (int i, CodeIdent id) {
	registerRelease (id);
	regused[i] = id;
	regdrty[i] = true;
    }

    public int registerGive (CodeIdent e1, CodeIdent e2) {
	for (int i = 0; i < 7; i ++) {
	    if (regused[i] == null)
		return (i);
	}
	for (int i = 0; i < 7; i ++) {
	    if ((! regused[i].equals (e1)) && (! regused[i].equals (e2)) && (! regused[i].isTemp ())) {
		registerRelease (regused[i]);
		return (i);
	    }
	}
	return (-1);
    }

    public int registerGive (CodeIdent id, CodeIdent e1, CodeIdent e2) {
	int r = registerGive (e1, e2);
	registerSet (r, id);
	return r;
    }

    public ArrayList<String> registerLoad (int r, Code c) {
	ArrayList<String> sa = new ArrayList<String> ();
	String nr = registerName (r);
	if (c instanceof CodeIdent) {
	    CodeIdent id = (CodeIdent) c;
	    int i = registerFind (id);
	    if (i == -1)
		sa.add ("\tmrmovl " + id.getLabel () + "," + nr);
	    else
		sa.add ("\trrmovl " + registerName (i) + "," + nr);
	    regused[r] = id;
	}
	else
	    sa.add ("\tirmovl " + c.toString () + "," + nr);
	regdrty[r] = true;
	return sa;
    }

    public void registerRelease (CodeIdent id) {
	for (int i = 0; i < 7; i ++) {
	    if ((regused[i] != null) && (regused[i].equals (id)))
		regused[i] = null;
	}
    }

    public ArrayList<String> registerCallerPurge () {
	ArrayList<String> sa = new ArrayList<String> ();
	for (int i = 0; i < 3; i ++) {
	    if (regused[i] != null) {
		if (regused[i].isTemp ()) {
		    String s = regused[i].getLabel ();
		    dataset.add (s);
		    sa.add ("\trmmovl " + registerName (i) + "," + s);
		}
		regused[i] = null;
	    }
	}
	return (sa);
    }

    public ArrayList<String> registerCalleeSave () {
	ArrayList<String> sa = new ArrayList<String> ();
	for (int i = 3; i < 7; i ++) {
	    if (regdrty[i])
		sa.add ("\tpushl " + regname[i]);
	}
	return (sa);
    }

    public ArrayList<String> registerCalleeRestore () {
	ArrayList<String> sa = new ArrayList<String> ();
	for (int i = 6; i >= 3; i --) {
	    if (regdrty[i])
		sa.add ("\tpopl " + regname[i]);
	}
	return (sa);
    }

    public void identAdd (String s) {
	if (s.charAt (0) != '#')
	    dataset.add (s);
    }

    public ArrayList<String> assemble () {
	ArrayList<String> sa = new ArrayList<String> ();
	sa.add ("\t.align 4");
	Iterator<String> si = dataset.iterator();
	while (si.hasNext ())
	    sa.add (si.next () + ":\t.long 0");
	return sa;
    }

    public String toString () {
	String s = "";
	for (int i = 0; i < 7; i ++) {
	    String s2 = regname[i] + ":";
	    if (regused[i] != null)
		s2 += " " + regused[i].getLabel ();
	    s += s2 + "\n";
	}
	return (s);
    }
}
