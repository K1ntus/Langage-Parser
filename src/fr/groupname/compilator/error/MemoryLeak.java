package fr.groupname.compilator.error;

public class MemoryLeak extends Exception {
	private static final long serialVersionUID = 1L;

	public MemoryLeak(String e) {
		System.out.println("[MEMLEAK] " + e);
		
	}
}
