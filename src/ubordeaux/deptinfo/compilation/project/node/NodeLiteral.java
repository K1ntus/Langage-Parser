package ubordeaux.deptinfo.compilation.project.node;

import java.math.BigInteger;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeBoolean;
import ubordeaux.deptinfo.compilation.project.type.TypeInt;
import ubordeaux.deptinfo.compilation.project.type.TypeNull;
import ubordeaux.deptinfo.compilation.project.type.TypeString;

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

	@SuppressWarnings("unused")
	private String stringToHex(String arg) {
	    return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
	}
	
	@SuppressWarnings("unused")
	private int hexToString(String hexa) {
		int res = new Integer(Integer.decode (hexa));
		//BigInteger res = new BigInteger(hexa, 16);
		return res;
	}

	public Const generateIntermediateCode() {
		Const res = null;
		
		if(this.getType() instanceof TypeInt) { 
			res = new Const((int) this.getValue());
	 	} else if(this.getType() instanceof TypeBoolean) {
	 		int val = (boolean) (this.getValue()) ? 1 : 0;
			res = new Const(val);
		} else if(this.getType() instanceof TypeString) {	//p. 168
			res = new Const(-1);
			//res = new Const(this.hexToString(this.stringToHex((String) this.getValue())));
		}
		return res;
	}

	
}
