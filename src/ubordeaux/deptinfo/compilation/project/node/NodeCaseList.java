package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
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

	public IntermediateCode generateIntermediateCode(NodeExp exp, LabelLocation l) {
		
		NodeCaseList clone = this.clone();
		
		
		NodeCase tmp = (NodeCase)clone.get(0);
		IntermediateCode stat = tmp.generateIntermediateCodeCase(exp,l);

		if (clone.size() > 1 && clone.get(0) != null) {
			clone.elts.remove(0);
			return new Seq((Stm)stat, (Stm)clone.generateIntermediateCode(exp, l)) ;
		}

		return new Seq((Stm)stat, new Label(l));
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		System.err.println("errr case list wrong!");
		return new Const(0);
	}

}
