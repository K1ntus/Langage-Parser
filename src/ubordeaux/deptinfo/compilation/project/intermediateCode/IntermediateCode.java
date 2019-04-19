package ubordeaux.deptinfo.compilation.project.intermediateCode;

public abstract class IntermediateCode {

	// Pour un affichage lisible
	public abstract String toString();
	
	// Transforme l'arbre pour éliminer les ESEQ locaux
	public abstract void canonicalTransformation();
	
}
