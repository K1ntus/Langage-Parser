package ubordeaux.deptinfo.compilation.project.node;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.type.Type;

public final class NodeLiteral extends NodeExp {

	private Object value;

	public NodeLiteral(Type type, Object value) {
		super();
		this.type = type;
		this.value = value;
	}

	public String toString() {
		//return "NodeLiteral("+type+", "+value+")";
		return this.getClass().getSimpleName() + '#' + value + ':' + type + '#';
	}

	@Override
	public boolean checksType() {
		super.checksType();
		return true;
	}

	public String toDotNodeName() {
		return "NodeLiteral " + value.toString();
	}

	@Override
	public NodeLiteral clone() {
		return new NodeLiteral(type, value);
	}
	
	public Object getValue() {
		return value;
	}
	
	public Type getType() {
		return type;
	}

	public Move generateIntermediateCodeLiteral() {
		//System.out.println(this.getValue().getClass().toString());
		ExpList l = new ExpList(null, null);
		Exp exp = l.getHead();
		TempValue tmp = new TempValue();
		//if()
		
		return new Move(new Temp(tmp),exp);
	}

	
}
