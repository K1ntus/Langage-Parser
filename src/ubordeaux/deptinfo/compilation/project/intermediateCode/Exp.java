package ubordeaux.deptinfo.compilation.project.intermediateCode;

public abstract class Exp extends IntermediateCode {

	@Override
	public void canonicalTransformation() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".canonicalTransformation()()");
	}
	

	public abstract String toString();
}