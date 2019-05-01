package fr.c12.compilator.converter.code;

import java.util.ArrayList;

import fr.c12.compilator.converter.AssemblyTable;

public class CodeList {
    private ArrayList<Code> list;
    private int idnum;

    public CodeList () {
	this.list = new ArrayList<Code> ();
	this.idnum = 0;
    }

    public void add (Code c) {
	list.add (c);
    }

    public int getSize () {
	return (list.size ());
    }

    public CodeIdent newCodeIdent () {
	CodeIdent i = new CodeIdent ("#t" + Integer.toString (idnum));
	idnum += 1;
	return i;
    }

    public ArrayList<String> assemble (AssemblyTable at) {
	ArrayList<String> s = new ArrayList<String> ();
	for (int i = 0; i < list.size (); i ++)
	    s.addAll (list.get (i).assemble (at));
	return s;
    }

    public String toString () {
	String s = "";
	for (int i = 0; i < list.size (); i ++)
	    s = s + (list.get (i)).toString () + "\n";
	return (s);
    }
}
