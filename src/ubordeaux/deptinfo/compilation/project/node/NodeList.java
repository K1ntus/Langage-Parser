package ubordeaux.deptinfo.compilation.project.node;

import java.util.Iterator;

import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;

public final class NodeList extends Node {

	public NodeList(Node stm) {
		super(stm);
	}

	public NodeList() {
		super();
	}

	@Override
	public boolean checksType() {
		super.checksType();
		boolean result = true;
		for (Node elt : this.elts) {
			if (elt != null && !elt.checksType())
				result = false;
		}
		return result;
	}

	public Iterator<Node> iterator() {
		return this.elts.iterator();
	}

	public int size() {
		return this.elts.size();
	}
	

	@Override
	public NodeList clone() {
		NodeList node = new NodeList();
		for (Node elt : this.elts) {
			node.add((Node) elt.clone());
		}
		return node;
	}


	public IntermediateCode generateIntermediateCode() {
		for (Node elt : this.elts) {
			switch(elt.getClass().toString()) {
				case "class ubordeaux.deptinfo.compilation.project.node.NodeArrayAccess":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeAssign":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeCallFct":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeCase":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeCaseList":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeDispose":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeExp":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeId":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeIf":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeInterface":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeList":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeLiteral":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeNew":
					System.out.println(elt.getClass().toString());
					break;
				case "class ubordeaux.deptinfo.compilation.project.node.NodeOp":
					System.out.println(elt.getClass().toString());
					break;
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
				case "class ubordeaux.deptinfo.compilation.project.node.NodeWhile":
					System.out.println(elt.getClass().toString());
					break;
			
				default:
					System.out.println("-_-_-_-DEFAULT-_-_-_-");
					//System.out.println("");
						
			}
			
		}
		return null;
		
	}
}
