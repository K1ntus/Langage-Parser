package fr.c12.compilator.error;

public class AlreadyDefinedType extends Exception {
	private static final long serialVersionUID = 1L;

	public AlreadyDefinedType(String e) {
		System.out.println("[TypeAlreadyDefined] " + e);
		
	}
}
