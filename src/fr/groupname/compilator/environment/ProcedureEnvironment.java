package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Map;

import ubordeaux.deptinfo.compilation.project.node.NodeCallFct;
import ubordeaux.deptinfo.compilation.project.node.NodeList;
import ubordeaux.deptinfo.compilation.project.type.Type;

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
	


	public NodeCallFct getVariableValue(NodeCallFct t) throws NoSuchFieldException {
		System.out.println("** Retrouve fct:" + t.toString());
		String name = t.getName();
		return getNodeFct(name);
	}
	
	public NodeCallFct getNodeFct(String fct_name) throws NoSuchFieldException {
		for(NodeCallFct node_fct : table.keySet()) {
			String funct_tested = node_fct.getName();
			//System.out.println("Current function name tested: " + funct_tested);
			if(funct_tested.equals(fct_name)) {
				return node_fct;
			}
		}
		throw new NoSuchFieldException("Aucune fonction: " + fct_name + " trouvee.");
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
