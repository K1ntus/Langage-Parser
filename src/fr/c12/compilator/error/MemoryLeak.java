package fr.c12.compilator.error;

public class MemoryLeak extends Exception {
	private static final long serialVersionUID = 3L;

	public MemoryLeak(String e) {
		System.out.println("[MEMLEAK] " + e);
		
	}
}
