package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Map;

import ubordeaux.deptinfo.compilation.project.type.Type;

public class TypeEnvironment {
	private String name;
	private Map<String, Type> table;

	
	public TypeEnvironment(){
		table = new HashMap<String, Type>();
	}
	
	/**
	 * @param environment_type (equals: "types", "procedures")
	 */
	public TypeEnvironment(String name) {
		this();
		this.name = name;
	}
	
	
	

	

	public void putVariable(String t, Type n) {
		table.put(t, n);
		System.out.println("** Enregistre " + name + ": " + n.toString());
	}

	public Type getVariableValue(String t) {
		System.out.println("** Retrouve " + name + ": " + t + " " + table.get(t));
		return table.get(t);
	}
	
	
	
	
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the env
	 */
	public Map<String, Type> getEnv() {
		return table;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param env the env to set
	 */
	public void setEnv(Map<String, Type> env) {
		this.table = env;
	}
}