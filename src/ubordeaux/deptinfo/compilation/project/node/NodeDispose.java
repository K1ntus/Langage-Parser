package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;

public final class NodeDispose extends Node {

	public NodeDispose(Node e) {
		super(e);
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	@Override
	public NodeDispose clone() {
		return new NodeDispose((Node) this.get(0).clone());
	}


	public Const generateIntermediateCodeDispose() {
		System.err.println("* FREE("+this+") - Todo");
		/*
		System.out.println("FREE3" + ((NodeId)this.get(0)).getName());
		Name n = new Name(
				new LabelLocation(
				((NodeId)this.get(0)).getName()))
			
		return new Move(n, new Const(0));	;
		*/
		
		return new Const(0);
	}
	
}
