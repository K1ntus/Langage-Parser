package ubordeaux.deptinfo.compilation.project.node;


import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.type.Type;

public final class NodeAssign extends Node {

	public NodeAssign(NodeExp lhs, NodeExp rhs) {
		super(lhs, rhs);
		//System.out.println("* Assignment: " + this.toString());
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if (!get(0).checksType())
			return false;
		if (!get(1).checksType())
			return false;
		Type lhsType = this.getLhs().getType();
		Type rhsType = this.getRhs().getType();
		if (lhsType == null || rhsType == null || !lhsType.equals(rhsType)) {
			System.err.println("- NodeAssign not well typed");
			try {
				System.err.println("- LeftType: " + lhsType.toString());				
			} catch (Exception e) {
				System.err.println("Problem with LeftType. mb null.");
			}
			try {
				System.err.println("- RightType: " + rhsType.toString());			
			} catch (Exception e) {
				System.err.println("Problem with RightType. mb null.");
			}
			return false;
		}
		System.out.println("- Assign well typed");
			return true;
	}

	private NodeExp getLhs() {
		return (NodeExp) this.get(0);
	};
	
	private NodeExp getRhs() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeAssign clone() {
		return new NodeAssign((NodeExp) getLhs().clone(), (NodeExp) getRhs().clone());
	};
	


	public Move generateIntermediateCodeAssign() {
		ExpList l = new ExpList((Exp)this.getLhs().generateIntermediateCode(), null);
		ExpList r = new ExpList((Exp)this.getRhs().generateIntermediateCode(), null);
		//ExpList l = new ExpList(null, null);
		//ExpList r = new ExpList(null, null);
		return new Move(new Mem(l.getHead()),r.getHead() );	
	}
}
