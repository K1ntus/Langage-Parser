package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Mem;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeComplex;
import ubordeaux.deptinfo.compilation.project.type.TypePointer;

public final class NodePtrAccess extends NodeExp {

	// e = NodeExp(TypePointer(\tau))
	public NodePtrAccess(NodeExp e) {
		super(e);
		if (e.getType() instanceof TypeComplex) {
			Type t = (TypeComplex) e.getType();
			if (t != null && (t instanceof TypePointer)) {
				Type tr = ((TypePointer) t).get(0);
				if (tr != null)
					this.type = tr;
			}
		}
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodePtrAccess clone() {
		return new NodePtrAccess((NodeExp) this.get(0).clone());
	}

	public Mem generateIntermediateCodePtr() {	//p. 163
		Exp name = (Exp) get(0).generateIntermediateCode();
		
		return new Mem(name);
	}
}
