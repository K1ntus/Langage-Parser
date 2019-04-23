package ubordeaux.deptinfo.compilation.project.node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.c12.compilator.error.UnknownNodeType;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.main.ClonableSymbol;

public abstract class Node extends ClonableSymbol implements NodeInterface {

	protected List<Node> elts;
	protected int uniqId;
	private static int staticUniqId;

	public Node() {
		super();
		this.uniqId = Node.staticUniqId++;
		//System.err.println("Create class " + this.getClass().getSimpleName());
		this.elts = new ArrayList<Node>();
		
	}

	public Node(Node ... args) {
		this();
		for (Node elt : args) {
			elts.add(elt);
		}
	}
	
	public List<Node> getList(){
		return elts;
	}

	public String toString() {
		String ret = this.getClass().getSimpleName();
		if (elts.size() > 0)
			ret += '(';
		boolean first = true;
		for (Node elt : this.elts) {
			if (first)
				first = false;
			else
				ret += ", ";
			try {
				ret += elt.toString(); 
			}
			catch(NullPointerException e) {
				ret+= "NULL";
			}
		}
		if (elts.size() > 0)
			ret += ')';
		return ret;
	}

	@Override
	public boolean checksType() {
		System.err.println("--- CheckType " + this.getClass().getSimpleName());
		return false;
	};
	
	public void add(Node elt) {
		this.elts.add(elt);
	}
	
	public void pop(Node elt) {
		this.elts.remove(elt);
		
	}

	public Node get(int i) {
		return elts.get(i);
	}

	public int size() {
		return elts.size();
	}

	private final void toDot(StringBuffer stringBuffer) {
		stringBuffer.append("node_" + this.uniqId + " [shape=\"ellipse\", label=\"" + toDotNodeName() + "\"];\n");
		for (Node elt : this.elts) {
			elt.toDot(stringBuffer);
			stringBuffer.append("node_" + this.uniqId + " -> node_" + elt.uniqId + ";\n");
		}

	}

	protected String toDotNodeName() {
		return getClass().getSimpleName();
	}

	public final void toDot(String file) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write("digraph Stree {\n");
			StringBuffer str = new StringBuffer();
			toDot(str);	
			out.write(str.toString());
			out.write("}\n");
			out.close();
		} catch (IOException e) {
			System.err.println("ERROR: build dot");
		}
	}

	
	
	/**
	 * Presque aussi rapide qu un switch case, si ce n est autant ;)
	 * 
	 * A ce qu il parait, a partir de java8 on peut aussi utiliser 
	 * lambda ou method reference pour eviter de creer des sous-classes Handler
	 * et rendre le code plus court pour un resultat similaire
	 * (en plus, ca fait lgtps que je veux try les lambda ref, askip cest de la prog fonct.)
	 *
	 */
	
	//Une interface pour un objet Polymorphe 'Handler'. 
	//Forcer l'implementation de cette interface ainsi, pour éviter de niquer la table
	//Avec plusieurs définitions de "Handler"
	private interface Handler {
	    void handle(Node o);
	}
	
	//On cree une map qui assigne un Handler a un objet "Class"
	private static final Map<Class, Handler> intermediate_code_table = new HashMap<Class, Handler>();
	
	// Remplit la map avec un bloc static (static initializer). Execute quand l objet Handler est initialisee
	static {
		intermediate_code_table.put(NodeOp.class, new Handler() {
	        public void handle(Node o) {
	            ((NodeOp)o).generateIntermediateCodeOp();
	        }
	    });
		
		intermediate_code_table.put(NodeList.class, new Handler() {	//On insert dans la table le Node.Class, et en key la fonction qui handle la generation de code intermediaire du noeud
	        public void handle(Node o) {
	            ((NodeList)o).generateIntermediateCodeList();
	        }
	    });
		
		intermediate_code_table.put(NodeAssign.class, new Handler() {
	        public void handle(Node o) {
	            ((NodeAssign)o).generateIntermediateCodeAssign();
	        }
	    });
		
		intermediate_code_table.put(NodeId.class, new Handler() {
	        public void handle(Node o) {
	            ((NodeId)o).generateIntermediateCodeMem();
	        }
	    });
		
		intermediate_code_table.put(NodeExp.class, new Handler() {
	        public void handle(Node o) {
	            ((NodeExp)o).generateIntermediateCodeExp();
	        }
	    });
		
		intermediate_code_table.put(NodeCallFct.class, new Handler() {
	        public void handle(Node o) {
	            //((NodeCallFct)o).generateIntermediateCodeCallFct();	//null pointer exception
	        }
	    });
		
		intermediate_code_table.put(NodeWhile.class, new Handler() {
	        public void handle(Node o) {
	            ((NodeWhile)o).generateIntermediateCodeWhile();
	        }
	    });
	}
	
	//Cherche un handler dans al table
	//S'il n'y en a pas, alors type de node inconnu. On throw une erreur.
	//(a ajouter dans la generation de code intermediaire)?
	//Sinon on l'appel avec la valeur du noeud
	private static void handle(Node o) throws UnknownNodeType{
	    Handler h = intermediate_code_table.get(o.getClass());
	    if (h == null) {
	    	throw new UnknownNodeType(o.toString());
	    }
	    h.handle(o);
	}
	
	
	
	
	public IntermediateCode generateIntermediateCode() {
		//for (Node elt : this.elts) {
			/* 
			try {
				handle(elt);
			} catch (UnknownNodeType e) {
				System.err.println("Recover From Intermediate Code Generation Error:" + e);
			}
			*/
			
			/*
			switch(elt.getClass().toString()) {
				case NodeArrayAccess.class:
					System.out.println(elt.getClass().toString());
					break;
				//case "class ubordeaux.deptinfo.compilation.project.node.NodeAssign":
				//	System.out.println("code intermediaire assign");
				//	((NodeAssign)elt).generateIntermediateCodeAssign();
				//	break;
				//case "class ubordeaux.deptinfo.compilation.project.node.NodeCallFct":
				//	System.out.println("intermediate code call");
				//	//((NodeCallFct)elt).generateIntermediateCodeCallFct(); //null pointer exception
				//	break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeCase":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeCaseList":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeDispose":
					System.out.println(elt.getClass().toString());
					break;
				//case "class ubordeaux.deptinfo.compilation.project.node.NodeExp":
				//	System.out.println("code intermediaire expression");
				//	 ((NodeExp)elt).generateIntermediateCodeExp();
				//	break;
				//case "class ubordeaux.deptinfo.compilation.project.node.NodeId":
				//	System.out.println("code intermediaire ID");
				//	((NodeId)elt).generateIntermediateCodeMem();
				//	break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeIf":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeInterface":
					System.out.println(elt.getClass().toString());
					break;
				//case "class ubordeaux.deptinfo.compilation.project.node.NodeList":
				//	System.out.println("code intermediaire list");
				//	((NodeList)elt).generateIntermediateCodeList();
				//	break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeLiteral":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeNew":
					System.out.println(elt.getClass().toString());
					break;
				//case "class ubordeaux.deptinfo.compilation.project.node.NodeOp":
				//	System.out.println("code intermediaire operation");
				//	((NodeOp)elt).generateIntermediateCodeOp();
				//	break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodePtrAccess":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeRel":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeReturn":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeSwitch":
					System.out.println(elt.getClass().toString());
					break;
				//case "class ubordeaux.deptinfo.compilation.project.node.NodeWhile":
				//	System.out.println("Code intermediaire while");
				//	((NodeWhile)elt).generateIntermediateCodeWhile();
				//	break;
			
				default:
					System.out.println("-_-_-_-DEFAULT-_-_-_-");		//Ca doit etre beau comme message
			}
					*/
		//}
		return null;
	}

}
