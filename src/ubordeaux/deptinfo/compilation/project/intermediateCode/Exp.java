package ubordeaux.deptinfo.compilation.project.intermediateCode;

import ubordeaux.deptinfo.compilation.project.node.*;

public abstract class Exp extends IntermediateCode {

	@Override
	public void canonicalTransformation() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".canonicalTransformation()()");
	}


	public String toString() {
		return "Exp";	//pour le moment...
	}
}