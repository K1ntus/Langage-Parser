package ubordeaux.deptinfo.compilation.project.intermediateCode;

public abstract class IntermediateCode {

	// Pour un affichage lisible
	public String toString() {
		return this.getClass().toString();
	}
	
	// Transforme l'arbre pour éliminer les ESEQ locaux
	public abstract void canonicalTransformation();
	
}
