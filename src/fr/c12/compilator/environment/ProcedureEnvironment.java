package fr.c12.compilator.environment;

import java.util.HashMap;
import java.util.Map;

import fr.c12.compilator.error.RedefinitionFunction;
import fr.c12.compilator.error.RedefinitionFunctionPrototype;
import fr.c12.compilator.error.UnknownProcedure;
import ubordeaux.deptinfo.compilation.project.type.TypeFunct;

public class ProcedureEnvironment {
	private Map<String, TypeFunct> table;
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
	
	public void putVariable(String fct_node, TypeFunct fct_content) throws RedefinitionFunction, RedefinitionFunctionPrototype {
		if(table.get(fct_node) != null) {
			if(!table.get(fct_node).getDefined() && !fct_content.getDefined())
				throw new RedefinitionFunctionPrototype(fct_node);
			if(table.get(fct_node).getDefined()) {
				throw new RedefinitionFunction(fct_node);
			}
		}
		table.put(fct_node, fct_content);
		System.out.println("** Enregistre fct:" + fct_node.toString());		
	}
	


	public TypeFunct getVariableValue(String name) throws UnknownProcedure {
		System.out.println("** Retrouve fct: " +name);
		return getTypeFct(name);
	}
	
	public TypeFunct getTypeFct(String fct_name) throws UnknownProcedure {
		if(table.get(fct_name) != null)
			return table.get(fct_name);
		throw new UnknownProcedure("Aucune fonction: " + fct_name + " trouvee.");
	}
	
	
	/**
	 * @return the environment
	 */
	public Map<String, TypeFunct> getEnvironment() {
		return table;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(Map<String, TypeFunct> environment) {
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
