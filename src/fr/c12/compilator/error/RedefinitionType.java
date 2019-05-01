package fr.c12.compilator.error;

public class RedefinitionType extends Exception {
	private static final long serialVersionUID = 11L;

	public RedefinitionType(String e) {
		System.out.println("[RedefinitionType] " + e);
		
	}
}
