package fr.c12.compilator.environment;

import java.util.HashMap;
import java.util.Map;

import fr.c12.compilator.error.AlreadyDefinedFunction;
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
	
	public void putVariable(String fct_node, TypeFunct fct_content) throws AlreadyDefinedFunction {
		if(table.get(fct_node) != null) {
			if(table.get(fct_node).getDefined())
				throw new AlreadyDefinedFunction(fct_node);			
		}
		table.put(fct_node, fct_content);
		System.out.println("** Enregistre fct:" + fct_node.toString());		
	}
	


	public TypeFunct getVariableValue(TypeFunct t) throws NoSuchFieldException {
		System.out.println("** Retrouve fct:" + t.toString());
		String name = t.getName();
		return getNodeFct(name);
	}
	
	public TypeFunct getNodeFct(String fct_name) throws NoSuchFieldException {
		if(table.get(fct_name) != null)
			return table.get(fct_name);
		throw new NoSuchFieldException("Aucune fonction: " + fct_name + " trouvee.");
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
