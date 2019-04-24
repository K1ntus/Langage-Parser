package ubordeaux.deptinfo.compilation.project.main;

import java.io.FileReader;

import fr.c12.compilator.environment.StackEnvironment;
import ubordeaux.deptinfo.compilation.project.node.Node;


//import ubordeaux.deptinfo.compilation.project.node.Node;

public class Main {
	private static boolean checksType;

	public static void main(String[] args) throws Exception {
		for (String arg : args) {
			if (arg.charAt(0) == '-') {
				if (arg.equals("-checkType"))
					checksType = true;
			} else {
				ScannerExpr input = new ScannerExpr(new FileReader(arg));
				Parser parser = new Parser();
				try {
					System.err.println("\n\n\n*************************************************\n"
							+ "*** Fichier " + arg);
					//System.err.println("[INFO] $   : single line comment.");
					System.err.println("[INFO] $$  : multiple line comment.");
					System.err.println("[INFO] $$$ : documentation comment.\n\n");
					Node result = (Node) parser.parse(input);
					System.err.println("*** Analyse syntaxique ok");
					if (checksType) {
						if (!result.checksType())
							System.err.println("*** Erreur de typage");
						else
							System.err.println("*** Typage correct");
					}

					System.out.println("\n\nArbre Principal: ");
					System.out.println(result.toString());
					result.toDot("data/output_tree");
					
					System.out.println("\n\nCode intermediaire: ");
					System.out.println(result.generateIntermediateCode().toString()); //null pointer à finir 
					//result.toDot("data/intermediate_code");
					
				} catch (beaver.Parser.Exception e) {
					System.err.println("*** Erreur de syntaxe: " + arg + ":" + e.getMessage());
				}
			}

		}
	}
}