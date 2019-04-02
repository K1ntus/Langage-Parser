package fr.groupname.compilator.environment;

public class Environment {

	private EnvironmentEnum env_enum;
	private EnvironmentType env_type;
	private EnvironmentFunction env_function;
	private EnvironmentVariable env_variable;

	public Environment(){
		this.env_enum = new EnvironmentEnum();
		this.env_type = new EnvironmentType();
		this.env_function = new EnvironmentFunction();
		this.env_variable = new EnvironmentVariable();
	}
}
