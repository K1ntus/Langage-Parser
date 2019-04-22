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

	
	
	//https://stackoverflow.com/a/29570906	
	// Declare an interface for your polymorphic handlers to implement.
	// There will be only anonymous implementations of this interface.
	private interface Handler {
	    void handle(Node o);
	}
	// Make a map that translates a Class object to a Handler
	private static final Map<Class,Handler> intermediate_code_table = new HashMap<Class,Handler>();
	// Populate the map in a static initializer
	static {
		intermediate_code_table.put(NodeOp.class, new Handler() {
	        public void handle(Node o) {
	            ((NodeOp)o).generateIntermediateCodeOp();
	        }
	    });
		intermediate_code_table.put(NodeList.class, new Handler() {
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
	// This object performs the dispatch by looking up a handler,
	// and calling it if it's available
	private static void handle(Node o) throws UnknownNodeType{
	    Handler h = intermediate_code_table.get(o.getClass());
	    if (h == null) {
	    	throw new UnknownNodeType(o.toString());
	    }
	    h.handle(o); // <<== Here is the magic
	}
	
	
	
	
	public IntermediateCode generateIntermediateCode() {
		for (Node elt : this.elts) {
			try {
				handle(elt);
			} catch (UnknownNodeType e) {
				System.err.println("Recover From Intermediate Code Generation Error:" + e);
			}
			
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
					System.out.println("-_-_-_-DEFAULT-_-_-_-");		
			}
					*/
		}
		return null;
	}

}
