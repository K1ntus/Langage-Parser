package ubordeaux.deptinfo.compilation.project.node;

import java.util.Iterator;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Call;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;
import ubordeaux.deptinfo.compilation.project.intermediateCode.LabelLocation;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Name;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeFeature;
import ubordeaux.deptinfo.compilation.project.type.TypeFunct;

public final class NodeCallFct extends NodeExp {

	protected String name;

	// Application
	// (f : E1 x E2 ... x Ek -> F), (arg1, arg2, ..., argk)
	public NodeCallFct(String name, TypeFunct type, NodeList args) {
		super(args);
		this.name = name;
		this.type = type;
	}

	// Application
	// (f : E1 x E2 ... x Ek -> F), (arg1, arg2, ..., argk)
	public NodeCallFct(String name, TypeFunct type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	public TypeFunct getTypeFunct() {
		return (TypeFunct) this.type;
	}

	public Type getType() {
		return ((TypeFunct) this.type).getRet();
	}

	public String toString() {
		return name + '_' + super.toString();
	}

	// On parcourt les arguments et on vérifie qu'ils sont bien typés
	// On parcourt aussi les paramètres de la fonction
	// et on regarde que les types sont égaux
	public boolean checksType() {
		super.checksType();
		
		boolean result = true;
		
		Iterator<Node> itArgs = this.getArgs().iterator();
		Iterator<Type> itParams = ((TypeFunct) type).getParams().iterator();
		while (itArgs.hasNext() && itParams.hasNext()) {
			NodeExp arg = (NodeExp) itArgs.next();
			if (!arg.checksType()) {
				result = false;
				break;
			}
			Type argType = arg.getType();
			// chaque parametre est une feature nom : type
			Type paramType = ((TypeFeature) itParams.next()).getType();
			
			if (!paramType.equals(argType)) {
				System.out.println("- NodeCallFct not well typed");
				System.err.println("*** Erreur de typage :\n* Args Type: " + argType + "\n* Params Type: " + paramType);
				result = false;
				break;
			}
		}
		// Plus ou moins d'arguments que de parametres
		if (result && (itArgs.hasNext() || itParams.hasNext())) {
			System.out.println("- NodeCallFct not well typed");
			System.err.println("*** Erreur de typage: pas le même nombre de paramètres ");
			System.err.println("*** nb_params got: " + this.getArgs().getList().size() + " - Expected: " + ((TypeFunct) type).getParams().size());
			
			return false;
		}
		if(result)
			System.out.println("- NodeCallFct well typed");
		
		return result;
	}

	private NodeList getArgs() {
		return (NodeList) elts.get(0);
	}

	@Override
	public NodeCallFct clone() {
		NodeCallFct node = new NodeCallFct(name, (TypeFunct) type);
		for (Node elt : this.elts) {
			node.add((Node) elt.clone());
		}
		return node;
	}
	
	@Override
	protected String toDotNodeName() {
		return "NodeCallFct " + name + "()";
	}
	
	public String getName() {
		return name;
	}
	
	
    public Call generateIntermediateCode() {//we create a Call with the function name label and list of args
        LabelLocation label = new LabelLocation(this.getName());
        Name function = new Name(label);
        ExpList largs = this.getArgs().generateIntermediateCodeListArgs();
        Call res = new Call((Exp)function, largs);
        
        return res;
    }


}
