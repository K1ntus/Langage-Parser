package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;

public class NodeOp extends NodeExp {

	protected String name;

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
		super(op);
		this.name = name;
		// le type d'un opérateur 
		NodeExp exprFct = (NodeExp) this.get(0);
		type = exprFct.type;
	}
	
	@Override
	public boolean checksType() {
		super.checksType();
		if ((super.size() > 1) && getOp2()!=null && !this.getOp1().getType().equals(this.getOp2().getType()))
			return false;
		return true;
	}

	private NodeExp getOp1() {
		return (NodeExp) this.get(0);
	};
	
	private NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}

	@Override
	public NodeOp clone() {
		if (this.size()==1)
			return new NodeOp(name, (NodeExp) getOp1().clone());
		else if (this.size()==2)
			return new NodeOp(name, (NodeExp) getOp1().clone(), (NodeExp) getOp2().clone());
		return null;
		};
	

		
        public ExpList generateIntermediateCode() {
        	System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
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
                    
                case "an":
                    operation = 4;
                    break;
                case"or":
                    operation = 4;
                    break;
                case"lt":
                    operation = 10;
                    break;
                case"le":
                    operation = 11;
                    break;
                case"gt":
                    operation = 12;
                    break;
                case"ge":
                    operation = 13;
                    break;
                case"eq":
                    operation = 14;
                    break;
                case"ne":
                    operation = 15;
                    break;
                case"no":
                    operation = 16;
                    break;
            }
            
            return new ExpList(new Binop(operation,  this.getOp1().generateIntermediateCode().getHead(), this.getOp2().generateIntermediateCode().getHead()),null);

            
        }
}
