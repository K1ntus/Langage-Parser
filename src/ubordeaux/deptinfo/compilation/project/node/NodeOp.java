package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;

public class NodeOp extends NodeExp {

	private int op_type;

	// Opération binaire
	// f : E X F -> F
	public NodeOp(int name, NodeExp op1, NodeExp op2) {
		super(op1, op2);
		this.op_type = name;
		// le type d'un opérateur 
		NodeExp exprFct = (NodeExp) this.get(1);
		type = exprFct.type;
	}

	public NodeOp(int name, NodeExp op) {
		super(op, null);
		this.op_type = name;
		// le type d'un opérateur 
		NodeExp exprFct = (NodeExp) this.get(0);
		type = exprFct.type;
	}
	
	public final static int PLUS = 1, MINUS = -1, DIVIDE = -2, MULTIPLY = 2, UNKNOWN = 0;
	
	@Override
	public boolean checksType() {
		super.checksType();
		if ((super.size() > 1) && getOp2()!=null && !this.getOp1().getType().equals(this.getOp2().getType())) {
			System.out.println("- NodeOp not  well typed");
			return false;
		}
		System.out.println("- NodeOp well typed");
		return true; 
	}

	public NodeExp getOp1() { 
		return (NodeExp) this.get(0);
	}
	
	public NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}
	
	public int getName() {
		return this.op_type; 
	}

	@Override
	public NodeOp clone() {
		if (this.getOp2() == null)
			return new NodeOp(op_type, (NodeExp) getOp1().clone());
		else if (!(this.getOp2() == null))
			return new NodeOp(op_type, (NodeExp) getOp1().clone(), (NodeExp) getOp2().clone());
		return null;
		};
	
		

	
    public Binop generateIntermediateCode() { 
		Binop op = null;
		if(this.getExp(1) != null) {
			op = new Binop(op_type, 
					 	(Exp) this.getExp(0).generateIntermediateCode(), 
					 		(Exp) this.getExp(1).generateIntermediateCode()
					 );
		}else {
			op = new Binop(NodeOp.MULTIPLY, 
				 	(Exp) this.getExp(0).generateIntermediateCode(), 
				 		new Const(-1)
				 );
		}

		return op;
    }
}