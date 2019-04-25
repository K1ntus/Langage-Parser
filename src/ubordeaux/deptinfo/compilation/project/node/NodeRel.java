package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.type.*;

public class NodeRel extends NodeExp {

	private String name;

	// Relation binaire
	// f : E X F -> {0,1}
	public NodeRel(String name, Node op1, Node op2) {
		super(op1, op2);
		this.name = name;
		this.type = new TypeBoolean();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		if ((!(this.getOp1().getType() instanceof TypeInt)) || (!(this.getOp2().getType() instanceof TypeInt))) {
			System.out.println("- NodeRel well typed");
			return false;
		}
		System.out.println("- NodeRel well typed");
		return true;
	}

	public NodeExp getOp1() {
		return (NodeExp) this.get(0);
	};

	public NodeExp getOp2() {
		return (NodeExp) this.get(1);
	}
	
	public String getName(){
		return this.name;
	}

	@Override
	public NodeRel clone() {
		return new NodeRel(name, (Node) getOp1().clone(), (Node) getOp2().clone());
	};
	
	public int getCodeOp() {
		int operation = -1;
        
        switch(this.name) {
            case "an":
                operation = 4;
                break;
            case"or":
                operation = 5;
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
        }
       return operation;
	}
	

	public Binop generateIntermediateCodeRel() {
		/*
		 //Exp left = new Const (((NodeLiteral)n.get(i)).getValue());
		 //res = new Binop(n.getCodeOp(), n.getExp(0).generateIntermediateCodeExp(), n.getExp(1).generateIntermediateCodeExp());
		
		 Binop op = new Binop(this.getCodeOp(), 
				 new Const(
						 (int) ((NodeLiteral) this.getExp(0)).getValue()
						 ), 
				 new Const(
						 (int) ((NodeLiteral) this.getExp(1)).getValue()
						 )
				 );
		 System.out.println("* " + op.toString());
		 return op;
		//return new Binop(this.getCodeOp(), ((ExpList)this.getOp1().generateIntermediateCode()).getHead(), ((ExpList)this.getOp2().generateIntermediateCode()).getHead());
	}
	*/
		
		 //GERER NodeOP et NodeRel
		Binop res = null;
        Exp leftexp = null;
        Exp rightexp = null;
        int i = this.getCodeOp();
        if(this.getOp1() instanceof NodeLiteral) {
        	leftexp = ((NodeLiteral)this.getOp1()).generateIntermediateCodeLiteral();;
        }else if(this.getOp1() instanceof NodeId) {
        	leftexp = ((NodeId)this.getOp1()).generateIntermediateCodeId();
        }
        if(this.getOp2() instanceof NodeLiteral) {
        	rightexp = ((NodeLiteral)this.getOp2()).generateIntermediateCodeLiteral();
        }else if(this.getOp2() instanceof NodeId) {
            rightexp = ((NodeId)this.getOp2()).generateIntermediateCodeId();
        }
       
        res = new Binop(i,leftexp,rightexp);
        System.out.println(res.toString());
        return res;
	}
}
