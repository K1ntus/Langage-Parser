package fr.c12.compilator.error;

public class InvalidType extends Exception {
	private static final long serialVersionUID = 3L;

	public InvalidType(String e) {
		System.out.println("[InvalidType" + e);
		
	}
}
