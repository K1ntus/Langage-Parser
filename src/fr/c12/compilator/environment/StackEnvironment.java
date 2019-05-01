package fr.c12.compilator.environment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import fr.c12.compilator.error.MemoryLeak;
import fr.c12.compilator.error.RedefinitionVariable;
import fr.c12.compilator.error.UnknownVariable;
import ubordeaux.deptinfo.compilation.project.type.Type;
import ubordeaux.deptinfo.compilation.project.type.TypePointer;


//Local variable stack
/**
 * Manage the variable stack. Each stack is equivalent to a local scope.
 * The "First" one contains every variable that has been declared at the beginning of the program.
 *
 */
public class StackEnvironment {
	/**
	 * The Stack that will store the variable name and his type.
	 * Each variable can be find using his name (so a string) as a key and get his type (value of the key in the map)
	 */
	private Stack<Map<String, Type>> environment;

	/**
	 * If enabled, more informations will be displayed during the parsing of the LEA code
	 */
	private static boolean verbose = false;
	
	/**
	 * Initialize the Environment Stack
	 */
	public StackEnvironment() {		
		environment = new Stack<>();
		
	}
	
	//Input: "local variables stack"
	/**
	 * 
	 * @param str name parameter of the environment using in the %embed part of the lalr parser, somehow useless.
	 */
	public StackEnvironment(String str) {
		this();
	}

	
	/**
	 * Get a variable type depending of his name as a key.
	 * This function explore the whole Stack to get the latest 
	 * Type corresponding to this key.
	 * 
	 * This function is somehow deprecated because was made when we was manipulat poing node directly into the table
	 * And whatever the scope, the result here would be the same so we should just check the last scope.
	 * 
	 * @param id the name of the variable to find in the stack
	 * @return the Type linked to this variable name in the stack
	 * @throws UnknownVariable Exception throw when there s no key with this value in the table in the whole stack
	 */
	//haut vers bas, faut get le last equals sinon modifier et utiliser listIterator+hasPrevious
	public Type get_type_reachable(String id) throws UnknownVariable {
		//int layer = 0;	//Debugging purpose
		Type res = null;
		Iterator<Map<String, Type>> it = environment.iterator();
		
		while(it.hasNext()) {
			Map<String, Type> map = it.next();
			
			//System.out.println("map:" + map.toString());
			
			try {
				res = getTypeFromId(id, map);
			} catch (UnknownVariable e) {
				continue;
			}
			//layer +=1;
			
		}
		if(res != null) {
			//System.out.println("[STACK] Variable: "+ id +" found at Layer: " +layer);
			return res;
		}
		throw new UnknownVariable("Aucune variable ["+id+"] enregistree");
			
	}
	

	/**
	 * Get the type linked to a string in the map passed as a parameter
	 * 
	 * @param id Name of the variable to get
	 * @param map The map to explore
	 * @return Type of this variable string
	 * @throws UnknownVariable exception when there s no such key into the table
	 */
	private Type getTypeFromId(String id, Map<String, Type> map) throws UnknownVariable {
		Type res = map.get(id);
		if(res == null)
			throw new UnknownVariable("Aucune variable ["+id+"] enregistree a la couche :" + environment.size());
		return res;
	}


	/**
	 * Return the Map containing the latest scope of the program, but check before if the stack is not empty
	 * @return Map<String,  Type> latest scope
	 */
	private Map<String, Type> get_latest_scope(){
		if(environment.isEmpty())
			return environment.push(new HashMap<String, Type>());
		return environment.peek();
	}
	
	/**
	 * This function insert a (String, Type) to the latest scope of the stack table
	 * 
	 * @param id the name of the variable (used as the key of the table)
	 * @param n the type of the variable (used as the value of the table)
	 * @throws RedefinitionVariable exception throw if there s alreay a key (ie. a variable) with this name
	 */
	public void add_type_to_latest_portability(String id, Type n) throws RedefinitionVariable {
		if(verbose)
			System.out.println("* Enregistre " + id.toString());
		
		
		if(this.get_latest_scope().get(id) != null)
			throw new RedefinitionVariable(id);
		
		
		this.get_latest_scope().put(id, n);
	}

	/*
	 * Getter&Setter
	 */
	
	/**
	 * @return the environment
	 */
	public Stack<Map<String, Type>> getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(Stack<Map<String, Type>> environment) {
		this.environment = environment;
	}
	
	
	
	
	/*
	 * 
	 * Deprecated Functions
	 * 
	 */
	
	
	/**
	 * Add a variable (String, Type) to every current table of the stack
	 * Was used when misunterpreting the TOKEN_NEW usage
	 * 
	 * @param id
	 * @param n
	 */
	@Deprecated
	public void add_node_to_every_layer(String id, Type n) {
		Iterator<Map<String, Type>> it = environment.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			Map<String, Type> map = it.next();
			if(verbose)
				System.out.println("* Enregistre " + id.toString() + "at layer: " + i);
			map.put(id, n);
			i +=1;
		}
	}

	/**
	 * Add a variable (String, Type) to every current table of the stack
	 * Was used when misunterpreting the TOKEN_NEW usage
	 * 
	 * @param id name of the pointer to alloc
	 * @throws MemoryLeak was throw when double or more new
	 */
	@Deprecated
	public void alloc_variable(String id) throws MemoryLeak {
		Iterator<Map<String, Type>> it = environment.iterator();
		
		while(it.hasNext()) {
			Map<String, Type> map = it.next();
			//System.out.println("* Removed " + id.toString() + " at layer: " + i);
			if((map.get(id) instanceof TypePointer)) {
				throw new MemoryLeak("Variable: " + id + " double malloc tentative.");
			}
			TypePointer n_type = new TypePointer(map.get(id));
			map.put(id, n_type);
			
		}
	}

	/**
	 * Remove a variable (String, Type) to every current table of the stack
	 * Was used when misunterpreting the TOKEN_NEW usage
	 * 
	 * @param id name of the pointer to free
	 * @throws MemoryLeak was throw when double or more free
	 */
	@Deprecated
	public void dispose_variable(String id) throws MemoryLeak {
		Iterator<Map<String, Type>> it = environment.iterator();
		
		while(it.hasNext()) {
			Map<String, Type> map = it.next();
			//System.out.println("* Removed " + id.toString() + " at layer: " + i);
			if(!(map.get(id) instanceof TypePointer)) {
				throw new MemoryLeak("Variable: " + id + " already free'd or not a pointer.");
			}
			TypePointer n_type = (TypePointer) map.get(id);
			map.put(id, n_type.get(n_type.size()-1));
			
		}
	}
}
