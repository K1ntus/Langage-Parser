package fr.c12.compilator.error;

public class UnknownType extends Exception {
	private static final long serialVersionUID = 16L;

	public UnknownType(String e) {
		System.out.println("[UnknownType] " + e);
		
	}
}
