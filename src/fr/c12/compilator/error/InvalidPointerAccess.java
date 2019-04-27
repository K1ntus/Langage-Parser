package fr.c12.compilator.error;

public class InvalidPointerAccess extends Exception {
	private static final long serialVersionUID = 3L;

	public InvalidPointerAccess(String e) {
		System.out.println("[InvalidPointerAccess] " + e);
		
	}
}
