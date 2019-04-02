package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Map;

import fr.groupname.compilator.type.variable.GlobalVariable;

//Gere les variables locales + globales
public class EnvironmentVariable {
	
	private Map <String, Integer> table_local_variable;
	private Map <String, GlobalVariable> table_global_variable;

	public EnvironmentVariable(){
		this.table_local_variable = new HashMap<String, Integer>();
		this.table_global_variable = new HashMap<String, GlobalVariable>();
		//TODO
	}
	
	public void putVariable(String var, Integer value) {
		// TODO Auto-generated method stub
		
	}

	public Integer getVariableValue(String variable) {
		// TODO Auto-generated method stub
		return null;
	}

}
