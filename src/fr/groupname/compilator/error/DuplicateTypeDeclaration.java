package fr.groupname.compilator.error;

public class DuplicateTypeDeclaration extends Exception {
	private static final long serialVersionUID = 2L;

	public DuplicateTypeDeclaration(String e) {
		System.out.println("[TypeEnvironment] Overriding Type Declaration: " + e);
		
	}
}
