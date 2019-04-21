package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Map;

import fr.groupname.compilator.error.DuplicateTypeDeclaration;
import fr.groupname.compilator.error.UnknownType;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypeItemEnum;
import ubordeaux.deptinfo.compilation.project.type.TypeTuple;

public class TypeEnvironment {
	private String name;
	private Map<String, Type> table;

	
	public TypeEnvironment(){
		table = new HashMap<String, Type>();
		//table.put("integer",new TypeInt());
		//table.put("string",new TypeString());
		//table.put("boolean",new TypeBoolean());
	}
	
	/**
	 * @param environment_type (equals: "types", "procedures")
	 */
	public TypeEnvironment(String name) {
		this();
		this.name = name;
	}
	
	private boolean isTypeRegistered(Type t_to_compare) {
		for(Type t : table.values()) {
			if(t.getClass().equals(t_to_compare.getClass())) {
				return true;
			}
			
		}
		return false;
	}

	public void putVariable(String t, Type n) throws DuplicateTypeDeclaration{//, UnknownType {
		if(table.get(t) != null) {
			throw new DuplicateTypeDeclaration(t);
		}
		//if(!isTypeRegistered(n)) {
		//	throw new UnknownType(n.toString());
		//}
		
		table.put(t, n);
		System.out.println("** Enregistre " + name + ": " + n.toString());
	}

	public Type getVariableValue(String t) throws UnknownType {
		if(table.get(t) == null) {
			throw new UnknownType(t);
		}
		System.out.println("** Retrouve " + name + ": " + t + " " + table.get(t));
		return table.get(t);
	}
	
	public TypeItemEnum getEnumType(String id) throws NoSuchFieldException {
		for(Type t : table.values()) {
			if(t instanceof TypeTuple) {
				TypeTuple t_tuple = (TypeTuple) t;
				for(int i = 0; i < t_tuple.size(); i++) {
					if(t_tuple.get(i) instanceof TypeItemEnum) {
						TypeItemEnum t_enum = (TypeItemEnum) t_tuple.get(i);
						
						if(t_enum.getRefEnumRange().equals(id)){
							return t_enum;
						}
					} else {
						break;
					}
				}
			}
		}
		
		throw new NoSuchFieldException("No Enum type containing this value has been spotted");
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