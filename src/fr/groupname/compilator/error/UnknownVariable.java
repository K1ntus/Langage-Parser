package fr.groupname.compilator.error;

public class UnknownVariable extends Exception {
	private static final long serialVersionUID = 3L;

	public UnknownVariable(String e) {
		System.out.println("[TypeEnvironment] Trying to acces an unknwon type: " + e);
		
	}
}
