package fr.c12.compilator.error;

@Deprecated
public class MemoryLeak extends Exception {
	private static final long serialVersionUID = 8L;

	public MemoryLeak(String e) {
		System.out.println("[MEMLEAK] " + e);
		
	}
}
