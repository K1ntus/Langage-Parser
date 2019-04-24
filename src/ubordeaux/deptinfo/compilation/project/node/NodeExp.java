package ubordeaux.deptinfo.compilation.project.node;


import java.util.ArrayList;
import java.util.List;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.Exp;
import ubordeaux.deptinfo.compilation.project.intermediateCode.ExpList;
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
	
	
	 public Exp generateIntermediateCodeExp() {
		 //System.out.println("Size node exp assign: " + size());
		 Exp res = null;
		 if(size() == 0) {
			 if(this instanceof NodeLiteral) {
				 NodeLiteral n = (NodeLiteral) this;
				 if(n.getType() instanceof TypeInt) {
					 res = new Const((int) n.getValue());
			 	} else if(n.getType() instanceof TypeBoolean) {
					 res = new Const((int) n.getValue());
				 } else if(n.getType() instanceof TypeString)
					 res = new Const(-1);
			 }
			 //System.out.println(((Const)res).toString());
		 }else {
			 //GERER NodeOP et NodeRel
			 res = null;
			 //System.out.println("Left: " + this.get(0)) ;
		 }
		 
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
	        return res;
  
	 }
}
