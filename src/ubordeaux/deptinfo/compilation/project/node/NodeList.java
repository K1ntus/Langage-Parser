package ubordeaux.deptinfo.compilation.project.node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ubordeaux.deptinfo.compilation.project.type.Type;


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
			if (elt != null && !elt.checksType()) {
				System.out.println("Checktype invalid.");
				System.out.println("* elem:" + elt.toString());
				//System.out.println("* Checktype invalid.");
				result = false;	
			}
		}
		return result;
	}

	public Iterator<Node> iterator() {
		return this.elts.iterator();
	}
	

	public int size() {
		return this.elts.size();
	}

	public List<Type> getTypeList(){
		ArrayList<Type> res = new ArrayList<>();
		for(Node n : elts) {
			if(n instanceof NodeExp) {
				NodeExp n_exp = (NodeExp) n;
				res.add(n_exp.getType());
			}
		}
		return res;
	}
	public List<Node> getList(){
		return this.elts;
	}
	

	@Override
	public NodeList clone() {
		NodeList node = new NodeList();
		for (Node elt : this.elts) {
			node.add((Node) elt.clone());
		}
		return node;
	}

	@Override
	public void generateIntermediateCode() {
		// TODO Auto-generated method stub
		System.err.println("TODO: " + this.getClass().getSimpleName() + ".generateIntermediateCode()");
		
	}
}
