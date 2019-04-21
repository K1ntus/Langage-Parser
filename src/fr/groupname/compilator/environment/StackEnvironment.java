package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import fr.groupname.compilator.error.UnknownVariable;
import ubordeaux.deptinfo.compilation.project.type.Type;


//Local variable stack
public class StackEnvironment {
	private Stack<Map<String, Type>> environment;

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
			System.out.println("[STACK] Variable: "+ id +" found at Layer: " +layer);
			return res;
		}
		throw new UnknownVariable("Aucune variable similaire stackee trouvee");
			
	}
	

	public Type getLiteralFromId(String id, Map<String, Type> map) throws UnknownVariable {
		Type res = map.get(id);
		if(res == null)
			throw new UnknownVariable("[ERROR]Aucune variable similaire stackee trouvee"+"\n[ERROR]Stack Size:"+environment.size());
		return res;
	}

	

	public void add_node_to_latest_portability(String id, Type n) {
		System.out.println("* Enregistre " + id.toString());
		this.get_last_portability().put(id, n);
	}

	public void add_node_to_every_layer(String id, Type n) {
		Iterator<Map<String, Type>> it = environment.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			Map<String, Type> map = it.next();
			System.out.println("* Enregistre " + id.toString() + "at layer: " + i);
			map.put(id, n);
			i +=1;
		}
	}
	public void remove_node_to_every_layer(String id) {
		Iterator<Map<String, Type>> it = environment.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			Map<String, Type> map = it.next();
			System.out.println("* Removed " + id.toString() + "at layer: " + i);
			map.remove(id);
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
