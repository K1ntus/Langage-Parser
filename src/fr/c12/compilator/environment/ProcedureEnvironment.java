package fr.c12.compilator.environment;

import java.util.HashMap;
import java.util.Map;

import fr.c12.compilator.error.RedefinitionFunction;
import fr.c12.compilator.error.RedefinitionFunctionPrototype;
import fr.c12.compilator.error.UnknownProcedure;
import ubordeaux.deptinfo.compilation.project.type.TypeFunct;

/**
 * Class that will contain the table linking the function name and his Type
 * 
 */
public class ProcedureEnvironment {
	/**
	 * table that content the <Funct_name, Type_funct>. This table is somehow useless, because we can
	 * have the name of the function directly from TypeFunct, so an
	 * classical collections like a List would be enough to manage
	 * the procedures
	 */
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
	
	/**
	 * Register a TypeFunct depending of his key (a string representing the function name)
	 * 
	 * @param fct_type the function name
	 * @param fct_content the function args, name and output type
	 * @throws RedefinitionFunction	exception sent when we try to instanciate a function that is already define
	 * @throws RedefinitionFunctionPrototype exception send if we declare for the second time a prototype
	 */
	public void putVariable(String fct_type, TypeFunct fct_content) throws RedefinitionFunction, RedefinitionFunctionPrototype {
		if(table.get(fct_type) != null) {
			if(!table.get(fct_type).getDefined() && !fct_content.getDefined())
				throw new RedefinitionFunctionPrototype(fct_type);
			if(table.get(fct_type).getDefined()) {
				throw new RedefinitionFunction(fct_type);
			}
		}
		table.put(fct_type, fct_content);
		System.out.println("** Enregistre fct:" + fct_type.toString());		
	}
	

	/**
	 * Check if the 
	 * @param fct_name
	 * @return
	 * @throws UnknownProcedure
	 */
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
