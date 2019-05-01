package fr.c12.compilator.error;

public class InvalidAffectationType extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidAffectationType(String e) {
		System.out.println("[InvalidAffectationType] " + e);
		
	}
}
