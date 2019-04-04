package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Map;

import ubordeaux.deptinfo.compilation.project.type.Type;

//Gere les variables locales + globales
public class EnvironmentVariable {
	
	private Map <String, Type> table_local_variable;
	private Map <String, Type> table_global_variable;

	public EnvironmentVariable(){
		this.table_local_variable = new HashMap<String, Type>();
		this.table_global_variable = new HashMap<String, Type>();
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
