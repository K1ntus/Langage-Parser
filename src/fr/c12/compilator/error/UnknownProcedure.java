package fr.c12.compilator.error;

public class UnknownProcedure extends Exception {
	private static final long serialVersionUID = 15L;

	public UnknownProcedure(String e) {
		System.out.println("[UnknownProcedure] " + e);
		
	}
}
