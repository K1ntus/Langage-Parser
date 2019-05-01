package fr.c12.compilator.converter;

import java.util.ArrayList;

import fr.c12.compilator.converter.code.CodeList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;

public final class AssemblyGenerator {
	public static CodeList generateAssemblyCode(IntermediateCode inter_code){

		AssemblyTable at = new AssemblyTable();
		CodeList cl = new CodeList ();
		inter_code.linearize(cl);

	    ArrayList<String> ac = cl.assemble (at);

	    System.out.println("\nPre-y86: ");
	    System.out.println(cl);
	    
	    
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
		

		as.add ("stack:");
	    as.addAll (at.assemble ());
	    

	    /*	Basics Functions	*/
	    
	    
	    /*	Stack	*/
		/*
	    as.add (".pos 0x200");
	    as.add ("stack:");
	    for(String key : stackEnvironment.getEnvironment().get(0).keySet()) {
	    	as.add("l"+key+": .long "+0);
			Type value = stackEnvironment.getEnvironment().get(0).get(key);
			
			if(value instanceof TypeInt)
				pos +=6;
			if(value instanceof TypeBoolean)
				pos +=6;
			if(value instanceof TypeVoid)
				pos +=6;
			else
				pos +=120;	
				
			}
	    as.add("\n");
	    */
	    System.out.format ("Programme y86 :\n\n");
	    for (int i = 0; i < as.size (); i ++) {
	          System.out.format ("%s\n", as.get (i));
	    }
	      
	    return cl;
	}
}
