package ubordeaux.deptinfo.compilation.project.node;


import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.type.Type;

public final class NodeId extends NodeExp {

	protected String name;

	public NodeId(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String toString() {
		return "ID("+type+", "+name+")";
		//return this.getClass().getSimpleName() + "#" + name + ':' + type + '#';
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	protected String toDotNodeName() {
		return "NodeId " + name;
	}

	@Override
	public NodeId clone() {
		return new NodeId(name, type);
	}
	
	public String getName() {
		return name;
	}
	
	
	public Mem generateIntermediateCodeMem() {
		//System.err.println("Label: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		return new Mem((Exp)this.generateIntermediateCode());
	}
	
	public Type getType() {
		return type;
	}


}
