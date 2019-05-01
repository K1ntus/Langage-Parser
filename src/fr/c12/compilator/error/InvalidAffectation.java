package fr.c12.compilator.error;

public class InvalidAffectation extends Exception {
	private static final long serialVersionUID = 0L;

	public InvalidAffectation(String e) {
		System.out.println("[InvalidAffectation] " + e);
		
	}
}
