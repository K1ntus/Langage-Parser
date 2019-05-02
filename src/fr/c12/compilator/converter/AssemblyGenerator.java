package fr.c12.compilator.converter;

import java.util.ArrayList;

import fr.c12.compilator.converter.code.CodeList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;

public final class AssemblyGenerator {
	public static CodeList cl = new CodeList();
	
	public static CodeList generateAssemblyCode(IntermediateCode inter_code){

		AssemblyTable at = new AssemblyTable();
		inter_code.linearize(cl);

	    ArrayList<String> ac = cl.assemble (at);
	    
	    ArrayList<String> as = new ArrayList<String> ();
	    int pos = 0;

	    as.add (".pos 0");
	    as.add ("\tirmovl stack,%esp");
	    as.add ("\tjmp main");
	    
	    

	    as.add ("\nmain:");
	    as.addAll (at.registerCalleeSave ());
	    as.addAll (ac);
	    as.addAll (at.registerCalleeRestore ());
	    
	    as.add ("\thalt\n");
	    
/* Function mult */
	    as.add ("mult:");
	    as.add ("\tmrmovl 4(%esp), %ecx");
	    as.add ("\tmrmovl 8(%esp), %edx");
	    as.add ("\txorl %eax, %eax");
	    as.add ("multbcl:");
	    as.add ("\tandl %edx, %edx");
	    as.add ("\tje multfin");
	    as.add ("\taddl %ecx, %eax");
	    as.add ("\tisubl 1,%edx");
	    as.add ("\tjmp multbcl");
	    
	    as.add ("multfin: ret");
/*	Function Divide */

	    as.add ("div:");
	    as.add ("\tpopl %eax");
		as.add ("\tpopl %eax\n");
		

	    as.addAll (at.assemble ());


	    /*	Stack	*/
		as.add ("stack:");

	    
	    
	    System.out.format ("Programme y86 :\n\n");
	    for (int i = 0; i < as.size (); i ++) {
	          System.out.format ("%s\n", as.get (i));
	    }
	      
	    return cl;
	}
}
