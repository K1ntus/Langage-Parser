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


	public IntermediateCode generateIntermediateCodeList() {
		for (Node elt : this.elts) {
			return elt.generateIntermediateCode();
		}
		return null;
	}
}
