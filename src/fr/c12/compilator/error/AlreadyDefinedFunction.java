package fr.c12.compilator.error;

public class AlreadyDefinedFunction extends Exception {
	private static final long serialVersionUID = 6L;

	public AlreadyDefinedFunction(String e) {
		System.out.println("[AlreadyDefinedFunction] " + e);
	}
}