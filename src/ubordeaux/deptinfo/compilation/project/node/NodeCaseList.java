package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Cjump;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Label;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Seq;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Stm;

public final class NodeCaseList extends NodeExp {

	public NodeCaseList() {
		super();
	}

	public NodeCaseList(NodeCase...node) {
		super(node);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeCaseList clone() {
		NodeCaseList clone =  new NodeCaseList();
		for (Node elt : this.elts) {
			clone.add((Node) elt.clone());
		}
		return clone;
	}

	public IntermediateCode generateIntermediateCodeCaseList(NodeExp exp) {
		
		
		LabelLocation l = new LabelLocation();
		NodeCaseList clone = this.clone();
		if(clone.size()==0) { //CAS DE BUG
			return null;
		}
		NodeCase tmp = (NodeCase)clone.get(0);
		IntermediateCode stat = tmp.generateIntermediateCodeCase(exp,l);

		if (clone.size() > 1 && clone.get(0) != null) {
			clone.elts.remove(0);
			return new Seq((Stm)stat, (Stm)clone.generateIntermediateCodeCaseList(exp)) ;
		}

		return new Seq((Stm)stat, new Label(l));
	}
}
