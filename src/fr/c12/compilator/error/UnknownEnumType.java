package fr.c12.compilator.error;

public class UnknownEnumType extends Exception {
	private static final long serialVersionUID = 4L;

	public UnknownEnumType(String e) {
		System.out.println("[UnknownEnumType] " + e);
		
	}
}
