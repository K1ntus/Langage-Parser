package ubordeaux.deptinfo.compilation.project.type;

public class TypeStruct extends TypeComplex {

	public TypeStruct(Type t) {
		super(t);
	}

	@Override
	public boolean attestWellFormed() {
		return true;
	}

	@Override
	public Type clone() {
		return new TypeStruct((Type) get(0).clone());
	}

	@Override
	public String declarey86() {
		// TODO Auto-generated method stub
		return null;
	}  

}
