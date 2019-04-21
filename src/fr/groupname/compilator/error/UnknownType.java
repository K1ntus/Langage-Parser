package fr.groupname.compilator.error;

public class UnknownType extends Exception {
	private static final long serialVersionUID = 1L;

	public UnknownType(String e) {
		System.out.println("[UnknownType] " + e);
		
	}
}
