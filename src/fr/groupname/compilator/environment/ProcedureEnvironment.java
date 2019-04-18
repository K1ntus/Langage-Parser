package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Map;

import ubordeaux.deptinfo.compilation.project.node.NodeCallFct;
import ubordeaux.deptinfo.compilation.project.node.NodeList;

public class ProcedureEnvironment {
	private Map<NodeCallFct, NodeList> table;
	private String name;
	

	public ProcedureEnvironment() {
		table = new HashMap<>();
		this.setName("procedures");
	}
	
	/**
	 * @param environment_type (equals: "types", "procedures")
	 */
	public ProcedureEnvironment(String name) {
		this();
		this.setName(name);
	}
	
	public void putVariable(NodeCallFct fct_node, NodeList fct_content) {
		table.put(fct_node, fct_content);
		System.out.println("** Enregistre fct:" + fct_node.toString());		
	}
	
	
	
	
	/**
	 * @return the environment
	 */
	public Map<NodeCallFct, NodeList> getEnvironment() {
		return table;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(Map<NodeCallFct, NodeList> environment) {
		this.table = environment;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
