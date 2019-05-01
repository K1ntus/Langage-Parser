package ubordeaux.deptinfo.compilation.project.node;


import fr.c12.compilator.converter.code.Code;
import fr.c12.compilator.converter.code.CodeList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Name;
import ubordeaux.deptinfo.compilation.project.type.Type;

public final class NodeId extends NodeExp {

	protected String name;

	public NodeId(String name, Type type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String toString() {
		//return "ID("+type+", "+name+")";
		return this.getClass().getSimpleName() + "#" + name + ':' + type + '#';
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
	
	
	public Type getType() {
		return type;
	}
	
	public Name generateIntermediateCode() {
		LabelLocation l = new LabelLocation(this.getName());
		return new Name(l);
	}

}
