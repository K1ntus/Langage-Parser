package fr.groupname.compilator.environment;

public class Environment {

	private EnvironmentEnum env_enum;
	private TypeEnvironment env_type;
	private EnvironmentFunction env_function;
	private EnvironmentVariable env_variable;
	
	public Environment(){
		this.env_enum = new EnvironmentEnum();
		this.env_type = new TypeEnvironment();
		this.env_function = new EnvironmentFunction();
		this.env_variable = new EnvironmentVariable();
	}
	
	/**
	 * 
	 * 
	 * 
	 * @param environment_type (equals: "types", "procedures"
	 */
	public Environment(String environment_type) {
		
	}
}
