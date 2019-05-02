package fr.c12.compilator.error;

public class InvalidCallFunction extends Exception{
	private static final long serialVersionUID = 2L;

	public InvalidCallFunction(String e, int n_given, int n_expected) {
		System.out.println("[InvalidCallFunction] " + e + " : expected " + n_expected + " arguments but " + n_given +" were given");
		
	}
}
