package fr.c12.compilator.error;

public class InvalidArrayAccesType extends Exception {
	private static final long serialVersionUID = 2L;

	public InvalidArrayAccesType(String e) {
		System.out.println("[InvalidArrayAccesType] " + e);
		
	}
}
