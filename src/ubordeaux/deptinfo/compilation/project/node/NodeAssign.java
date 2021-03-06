package ubordeaux.deptinfo.compilation.project.node;


import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Mem;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Move;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeFunct;
import ubordeaux.deptinfo.compilation.project.type.TypePointer;
import ubordeaux.deptinfo.compilation.project.type.TypeVoid;

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
		if ((lhsType == null || rhsType == null || !lhsType.equals(rhsType)) && !(lhsType instanceof TypePointer && rhsType instanceof TypeVoid)) {
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
			
			
			if(!(rhsType == null)) {
				if(rhsType instanceof TypeFunct) {
					if(!((TypeFunct) rhsType).getRet().equals(lhsType)) {
						//throw new InvalidReturnType(((TypeFunct) rhsType).getRet().toString() + " -> " + lhsType.toString());
					}
				}
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
	


	public Move generateIntermediateCode() {//we move  the right son in the memory space of the left son
		Exp left = (Exp) this.getLhs().generateIntermediateCode();
		Exp right = (Exp) getRhs().generateIntermediateCode();
		Move m = new Move(new Mem(left), right);

		return m;		
	}
}
