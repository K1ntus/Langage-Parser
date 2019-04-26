package ubordeaux.deptinfo.compilation.project.node;


import java.util.ArrayList;
import java.util.List;

import ubordeaux.deptinfo.compilation.project.intermediateCode.*;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeBoolean;
import ubordeaux.deptinfo.compilation.project.type.TypeInt;
import ubordeaux.deptinfo.compilation.project.type.TypeString;

public abstract class NodeExp extends Node {

	protected Type type;

	public NodeExp(Node... abstTrees) {
		super(abstTrees);
	}

	public Type getType() {
		return this.type;
	}
	
	public List<Type> getTypeList() {
		ArrayList<Type> res = new ArrayList<>();
		ArrayList<Node> arr = new ArrayList<>(this.getList());
		for(Node n : arr) {
			System.out.println("Expr->Tuple: " + n.toDotNodeName());
			NodeExp current = (NodeExp) n;
			res.add(current.getType());
		}
		
		return res;		
	}
	
	
	public NodeExp getExp(int i) {
		return ((NodeExp) this.get(i));
	}
	
	 public Exp generateIntermediateCodeExp() {
		 //System.out.println("Size node exp assign: " + size());
		 //Exp res = null;
		 
		 Exp resBis = null;
		 /*
		 if(size() == 0) {
			 if(this instanceof NodeLiteral) {
				// System.out.println("node exp a lit" + this.getClass());
				 return ((NodeLiteral)this).generateIntermediateCodeLiteral();
			 }
			 //System.out.println(((Const)res).toString());
		 }else {
			 if (this instanceof NodeOp) {
				 NodeOp n = (NodeOp) this;
				 return n.generateIntermediateCodeOp();
			 }else if (this instanceof NodeRel) {
				 NodeRel n = (NodeRel) this;
				 return n.generateIntermediateCodeRel();
			 }else if (this instanceof NodeId) {
				 Name n = ((NodeId)this).generateIntermediateCodeId();
				 return n;
			 }
		 }*/
		 
		 resBis = (Exp)this.generateIntermediateCode();
		 
		 /*
	        if(this.size()>1){
	            NodeExp tmp = (NodeExp) this.get(0);
	            this.pop(this.get(0));
	            ExpList e = new ExpList((Exp)tmp.generateIntermediateCode(), this.generateIntermediateCodeExp());
	            System.err.println(e.toString());
	            return  e; 
	        }else if(super.size() <= 1) {
	            NodeExp tmp = (NodeExp) this;
	            ExpList e = new ExpList((Exp)tmp.generateIntermediateCode(), null);
	            System.err.println(e.toString());
	            return  e; 
	        }
	        */
		 
	        return resBis;
  
	 }
}
