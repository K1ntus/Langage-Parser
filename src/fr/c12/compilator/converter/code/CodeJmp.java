package fr.c12.compilator.converter.code;


public class CodeJmp extends Code{

	private String ext = "mp";
	
	
	public CodeJmp(String ext) {
		this.ext = ext;
	}
	
	@Override
	public String toString() {
		return "j"+ext+" -> ";
	}
}
