package ubordeaux.deptinfo.compilation.project.type;

import ubordeaux.deptinfo.compilation.project.main.ClonableSymbol;

public class TypeNull extends TypeAtomic {

	@Override
	public ClonableSymbol clone() {
		return new TypeNull();
	}
	
	@Override
	public String declarey86() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
