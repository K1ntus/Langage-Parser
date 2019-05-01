package fr.c12.compilator.error;

public class RedefinitionVariable extends Exception {
	private static final long serialVersionUID = 12L;

	public RedefinitionVariable(String e) {
		System.out.println("[RedefinitionVariable] " + e);
		
	}
}
