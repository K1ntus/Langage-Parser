package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Binop;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.type.TypeBoolean;
import ubordeaux.deptinfo.compilation.project.type.TypeInt;

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


	public ExpList generateIntermediateCodeRel() {
		//System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		//new Binop(operation,  ((ExpList)this.getOp1().generateIntermediateCode()).getHead(), ((ExpList)this.getOp2().generateIntermediateCode()).getHead())
		//return new ExpList(null,null);
		

		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		return null;
	}
}
