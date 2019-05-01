package ubordeaux.deptinfo.compilation.project.intermediateCode;

import java.util.Map;

import ubordeaux.deptinfo.compilation.project.type.Type;

@SuppressWarnings("unused")
public class Y86Converter {
	
	private int indent_level = 0;
	private final static int EAX = 0, ECX = 1, EDX = 2, EBX = 3, ESP = 4, EBP = 5, ESI = 6, EDI = 7;
	private int[] used = {ESP, EBP};
	
	public String convert(/*Seq root, */Map<String, Type> map) {
		String result = "";
		result += newline(".pos 0");
		result += newline("init:");
		indent_level++;
		result += newline(irmovl("Stack", "%esp"));
		result += newline(irmovl("Stack", "%ebp"));
		result += newline(call("Main"));
		result += newline(halt());
		indent_level--;
		result += newline("");
		result += newline("#Variables block #");
		result += initialiseVar(map)+"\n";
		result += newline("Main:");
		indent_level++;
		result += newline("ret");
		
		return result;
	}
	
	public String initialiseVar(Map<String, Type> map) {
		String result = "";
		for (String key : map.keySet()) {
			result += newline(key + ": " + map.get(key).declarey86());
		}
		return result;
	}
	
	public String treatANode(IntermediateCode node) {
		String result = "";
		
		if (node instanceof Seq && ((Seq) node).getLeft() != null) {
			result += treatANode(((Seq) node).getLeft());
		}
		if (node instanceof Seq && ((Seq) node).getRight() != null) {
			result += treatANode(((Seq) node).getRight());
		}
		
		
		
		return result;
	}
	
	
	private String newline(String line) {
		String result = "";
		for (int i = 0; i < indent_level; i++) {
			result += "    ";
		}
		return result+line+"\n";
	}
	
	private String halt() {
		return "halt";
	}
	
	private String ret() {
		return "ret";
	}
	
	private String irmovl(String i, String r) {
		return "irmovl " + i + " " + r;
	}
	
	private String rrmovl(String r1, String r2) {
		return "rrmovl " + r1 + " " + r2;
	}
	
	private String rmmovl(String r, String m) {
		return "rmmovl " + r + " " + m;
	}
	
	private String mrmovl(String m, String r) {
		return "mrmovl " + m + " " + r;
	}
	
	private String iaddl(int i, String r) {
		return "iaddl " + i + " " + r;
	}
	
	private String isubl(int i, String r) {
		return "isubl " + i + " " + r;
	}
	
	private String addl(String r1, String r2) {
		return "addl " + r1 + " " + r2;
	}
	
	private String subl(String r1, String r2) {
		return "subl " + r1 + " " + r2;
	}
	
	private String jump(String c, String label) {
		return "j" + c + " " + label;
	}
	
	private String pushl(String r) {
		return "pushl " + r;
	}
	
	private String popl(String r) {
		return "popl " + r;
	}
	
	private String call(String label) {
		return "call " + label;
	}

}
