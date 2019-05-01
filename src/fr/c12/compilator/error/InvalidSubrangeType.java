package fr.c12.compilator.error;

public class InvalidSubrangeType extends Exception {
	private static final long serialVersionUID = 6L;
	public InvalidSubrangeType(String e) {
		System.out.println("[InvalidSubrangeType] " + e);
	}

}
