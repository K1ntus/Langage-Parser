package fr.c12.compilator.error;

public class RedefinitionFunction extends Exception {
	private static final long serialVersionUID = 9L;

	public RedefinitionFunction(String e) {
		System.out.println("[RedefinitionFunction] " + e);
	}
}