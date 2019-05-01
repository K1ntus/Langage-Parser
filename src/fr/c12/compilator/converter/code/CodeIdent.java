package fr.c12.compilator.converter.code;

public class CodeIdent extends Code {
    public String name;

    public CodeIdent (String n) {
	this.name = n;
    }

    public boolean isTemp () {
	return (name.charAt (0) == '#');
    }

    public String getLabel () {
	if (isTemp ())
	    return ("t" + name.substring (1));
	else
	    return ("l" + name);
    }

    public boolean equals (CodeIdent c) {
	return (name.equals (c.name));
    }

    public String toString () {
	return (name);
    }
}
