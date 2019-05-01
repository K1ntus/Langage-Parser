package ubordeaux.deptinfo.compilation.project.node;

import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;

public class NodeOp extends NodeExp {

	private String name;

	// Opération binaire
	// f : E X F -> F
	public NodeOp(String name, NodeExp op1, NodeExp op2) {
		super(op1, op2);
		this.name = name;
		// le type d'un opérateur 
		NodeExp exprFct = (NodeExp) this.get(1);
		type = exprFct.type;
	}

	public NodeOp(String name, NodeExp op) {
		super(op, null);
		this.name = name;
		// le type d'un opérateur 
		NodeExp exprFct = (NodeExp) this.get(0);
		type = exprFct.type;
	}
	
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
	
	public String getName() {
		return this.name; 
	}

	@Override
	public NodeOp clone() {
		if (this.getOp2() == null)
			return new NodeOp(name, (NodeExp) getOp1().clone());
		else if (!(this.getOp2() == null))
			return new NodeOp(name, (NodeExp) getOp1().clone(), (NodeExp) getOp2().clone());
		return null;
		};
	
	public int getCodeOp() {
		int operation = -1;
        
        switch(this.name) {
            case "plus":
                operation = 0;
                break;
            case "minus":
                operation = 1;
                break;
            case "times":
                operation = 2;
                break;
            case "divide":
                operation = 3;
                break;
        }
       return operation;
	}
		
        public Binop generateIntermediateCode() { 
			Binop op = null;
			if(this.getExp(1) != null) {
				op = new Binop(this.getCodeOp(), 
						 	(Exp) this.getExp(0).generateIntermediateCode(), 
						 		(Exp) this.getExp(1).generateIntermediateCode()
						 );
			}else {
				op = new Binop(2, 
					 	(Exp) this.getExp(0).generateIntermediateCode(), 
					 		new Const(-1)
					 );
			}

			return op;
        }
}