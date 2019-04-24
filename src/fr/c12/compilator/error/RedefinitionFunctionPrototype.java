package fr.c12.compilator.error;

public class RedefinitionFunctionPrototype extends Exception {
	private static final long serialVersionUID = 1L;

	public RedefinitionFunctionPrototype(String e) {
		System.out.println("[RedefinitionFunctionPrototype] " + e);
		
	}
}
