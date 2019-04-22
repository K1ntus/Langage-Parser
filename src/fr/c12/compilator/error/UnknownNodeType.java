package fr.c12.compilator.error;

public class UnknownNodeType extends Exception {
	private static final long serialVersionUID = 3L;

	public UnknownNodeType(String e) {
		System.out.println("[UnknownNodeType] " + e);
		
	}
}
