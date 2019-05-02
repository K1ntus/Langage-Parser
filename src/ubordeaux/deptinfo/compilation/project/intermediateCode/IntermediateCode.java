package ubordeaux.deptinfo.compilation.project.intermediateCode;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;

public abstract class IntermediateCode {

	// Pour un affichage lisible
	public String toString() {
		return this.getClass().toString();
	}
	
	// Transforme l'arbre pour éliminer les ESEQ locaux
	public abstract void canonicalTransformation();
	

	public abstract Code linearize(CodeList cl);
}
