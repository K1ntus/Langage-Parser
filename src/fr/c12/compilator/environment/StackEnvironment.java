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
public class StackEnvironment {
	private Stack<Map<String, Type>> environment;

	private static boolean verbose = false;
	
	public StackEnvironment() {		
		environment = new Stack<>();
		
	}
	
	//Input: "local variables stack"
	public StackEnvironment(String str) {
		this();
	}
	
	public Map<String, Type> get_last_portability(){
		if(environment.isEmpty())
			return environment.push(new HashMap<String, Type>());
		return environment.peek();
	}
	
	//haut vers bas, faut get le last equals sinon modifier et utiliser listIterator+hasPrevious
	public Type get_node_reachable(String id) throws UnknownVariable {
		int layer = 0;
		Type res = null;
		Iterator<Map<String, Type>> it = environment.iterator();
		
		while(it.hasNext()) {
			Map<String, Type> map = it.next();
			
			try {
				res = getLiteralFromId(id, map);
			} catch (UnknownVariable e) {
				continue;
			}
			layer +=1;
			
		}
		if(res != null) {
			//System.out.println("[STACK] Variable: "+ id +" found at Layer: " +layer);
			return res;
		}
		throw new UnknownVariable("Aucune variable ["+id+"] enregistree");
			
	}
	

	public Type getLiteralFromId(String id, Map<String, Type> map) throws UnknownVariable {
		Type res = map.get(id);
		if(res == null)
			throw new UnknownVariable("Aucune variable ["+id+"] enregistree a la couche :" + environment.size());
		return res;
	}

	

	public void add_node_to_latest_portability(String id, Type n) throws RedefinitionVariable {
		if(verbose)
			System.out.println("* Enregistre " + id.toString());
		if(this.get_last_portability().get(id) != null)
			throw new RedefinitionVariable(id);
		this.get_last_portability().put(id, n);
	}

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
	
	public void alloc_variable(String id) throws MemoryLeak {
		Iterator<Map<String, Type>> it = environment.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			Map<String, Type> map = it.next();
			//System.out.println("* Removed " + id.toString() + " at layer: " + i);
			if((map.get(id) instanceof TypePointer)) {
				throw new MemoryLeak("Variable: " + id + " double malloc tentative.");
			}
			TypePointer n_type = new TypePointer(map.get(id));
			map.put(id, n_type);
			
			i +=1;
		}
	}


	public void dispose_variable(String id) throws MemoryLeak {
		Iterator<Map<String, Type>> it = environment.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			Map<String, Type> map = it.next();
			//System.out.println("* Removed " + id.toString() + " at layer: " + i);
			if(!(map.get(id) instanceof TypePointer)) {
				throw new MemoryLeak("Variable: " + id + " already free'd or not a pointer.");
			}
			TypePointer n_type = (TypePointer) map.get(id);
			map.put(id, n_type.get(n_type.size()-1));
			
			i +=1;
		}
	}


	
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
	
	
}
