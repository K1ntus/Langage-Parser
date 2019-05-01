package fr.c12.compilator.special;

import ubordeaux.deptinfo.compilation.project.intermediateCode.Const;
import ubordeaux.deptinfo.compilation.project.intermediateCode.IntermediateCode;
import ubordeaux.deptinfo.compilation.project.main.ClonableSymbol;
import ubordeaux.deptinfo.compilation.project.node.Node;

public class EmptyNode extends Node{

	@Override
	public ClonableSymbol clone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntermediateCode generateIntermediateCode() {
		return new Const(0);
	}

}
