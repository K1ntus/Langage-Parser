package fr.c12.compilator.error;

public class InvalidReturnType extends Exception {
	private static final long serialVersionUID = 5L;

	public InvalidReturnType(String e) {
		System.out.println("[InvalidReturnType] " + e);
		
	}
}
