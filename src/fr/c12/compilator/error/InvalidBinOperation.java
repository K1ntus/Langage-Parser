package fr.c12.compilator.error;

public class InvalidBinOperation extends Exception {
	private static final long serialVersionUID = 3L;

	public InvalidBinOperation(String e) {
		System.out.println("[InvalidBinaryOperation] " + e);
		
	}
}
