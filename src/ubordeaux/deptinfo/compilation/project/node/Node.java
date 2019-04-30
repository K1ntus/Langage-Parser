package ubordeaux.deptinfo.compilation.project.node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.c12.compilator.error.UnknownNodeType;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
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

	
	
	
	public IntermediateCode generateIntermediateCode() {
		switch(this.getClass().toString()) {
			case "class ubordeaux.deptinfo.compilation.project.node.NodeArrayAccess":
				//System.out.println(this.getClass().toString());
				return ((NodeArrayAccess)this).generateIntermediateCodeArray();
	
			case "class ubordeaux.deptinfo.compilation.project.node.NodeAssign":
				//System.out.println("code intermediaire assign");
				return ((NodeAssign)this).generateIntermediateCodeAssign();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeCallFct":
				//System.out.println("intermediate code call");
				return ((NodeCallFct)this).generateIntermediateCodeCallFct(); //null pointer exception
				
			//case "class ubordeaux.deptinfo.compilation.project.node.NodeCase":
				//System.out.println(n.getClass().toString());
				//return ((NodeCase)this).generateIntermediateCodeCase();
				
			/*case "class ubordeaux.deptinfo.compilation.project.node.NodeCaseList":
				//System.out.println(n.getClass().toString());
				return ((NodeCaseList)this).generateIntermediateCodeCaseList();*/
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeDispose":
				//System.out.println(n.getClass().toString());
	
				return ((NodeDispose)this).generateIntermediateCodeDispose();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeExp":
				//System.out.println("code intermediaire expression");
				return ((NodeExp)this).generateIntermediateCodeExp();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeId":
				//System.out.println("code intermediaire ID");
				return ((NodeId)this).generateIntermediateCodeId();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeIf":
				//System.out.println(n.getClass().toString());
				return ((NodeIf)this).generateIntermediateCodeIf();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeList":
				//System.out.println("code intermediaire list");
				return ((NodeList)this).generateIntermediateCodeList();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeLiteral":
				//System.out.println(n.getClass().toString());
				return ((NodeLiteral)this).generateIntermediateCodeLiteral();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeNew":
				//System.out.println(n.getClass().toString());
				return ((NodeNew)this).generateIntermediateCodeNew();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeOp":
				//System.out.println("code intermediaire operation");
				return ((NodeOp)this).generateIntermediateCodeOp();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodePtrAccess":
				//System.out.println(n.getClass().toString());
				return ((NodePtrAccess)this).generateIntermediateCodePtr();
	
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeRel":
				//System.out.println(n.getClass().toString());
				return ((NodeRel)this).generateIntermediateCodeRel();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeReturn":
				//System.out.println(n.getClass().toString());
				return ((NodeReturn)this).generateIntermediateCodeRet();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeSwitch":
				//System.out.println(n.getClass().toString());
				return ((NodeSwitch)this).generateIntermediateCodeSwitch();
				
			case "class ubordeaux.deptinfo.compilation.project.node.NodeWhile":
				//System.out.println("Code intermediaire while");
				return ((NodeWhile)this).generateIntermediateCodeWhile();
				
			default:
				System.err.println("Unknown node Type: " + this.toString() + " during the intermediate code generation process.");
				return new Const(0);
		}
	}
	
	
}
