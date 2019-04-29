package ubordeaux.deptinfo.compilation.project.node;

<<<<<<< HEAD
import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
=======
import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
>>>>>>> 157395d84057718cf89cfd3f73eacbfda0c147fe

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
<<<<<<< HEAD
		/*
		System.out.println("FREE3" + ((NodeId)this.get(0)).getName());
		Name n = new Name(
				new LabelLocation(
				((NodeId)this.get(0)).getName()))
			
		return new Move(n, new Const(0));	;
		*/
		
		return new Const(0);
=======
		return new Move(new Mem( (Exp) this.get(0).generateIntermediateCode() ),new Name( new LabelLocation("null")));
>>>>>>> 157395d84057718cf89cfd3f73eacbfda0c147fe
	}
	
}
