package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

import ubordeaux.deptinfo.compilation.project.node.NodeLiteral;


//Local variable stack
public class StackEnvironment {
	private Stack<Map<String, NodeLiteral>> environment;

	public StackEnvironment() {		
		environment = new Stack<>();
		
	}
	
	//Input: "local variables stack"
	public StackEnvironment(String str) {
		this();
	}
	
	public Map<String, NodeLiteral> get_last_portability(){
		if(environment.isEmpty())
			return environment.push(new HashMap<String, NodeLiteral>());
		return environment.peek();
	}
	
	//haut vers bas, faut get le last equals sinon modifier et utiliser listIterator+hasPrevious
	public NodeLiteral get_node_reachable(String id) throws NoSuchFieldException {
		int layer = 0;
		NodeLiteral res = null;
		Iterator<Map<String, NodeLiteral>> it = environment.iterator();
		
		while(it.hasNext()) {
			Map<String, NodeLiteral> map = it.next();
			
			try {
				res = getLiteralFromId(id, map);
			} catch (NoSuchFieldException e) {
				continue;
			}
			layer +=1;
			
		}
		if(res != null) {
			System.out.println("[STACK] Variable: "+ id +" found at Layer: " +layer);
			return res;
		}
		throw new NoSuchFieldException("Aucune variable similaire stackee trouvee");
			
	}
	

	public NodeLiteral getLiteralFromId(String id, Map<String, NodeLiteral> map) throws NoSuchFieldException {
		NodeLiteral res = map.get(id);
		if(res == null)
			throw new NoSuchFieldException("[ERROR]Aucune variable similaire stackee trouvee"+"\n[ERROR]Stack Size:"+environment.size());
		return res;
	}

	

	public void add_node_to_latest_portability(String id, NodeLiteral n) {
		System.out.println("* Enregistre " + id.toString());
		this.get_last_portability().put(id, n);
	}

	public void add_node_to_every_layer(String id, NodeLiteral n) {
		Iterator<Map<String, NodeLiteral>> it = environment.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			Map<String, NodeLiteral> map = it.next();
			System.out.println("* Enregistre " + id.toString() + "at layer: " + i);
			map.put(id, n);
			i +=1;
		}
	}
	public void remove_node_to_every_layer(String id) {
		Iterator<Map<String, NodeLiteral>> it = environment.iterator();
		
		int i = 0;
		while(it.hasNext()) {
			Map<String, NodeLiteral> map = it.next();
			System.out.println("* Removed " + id.toString() + "at layer: " + i);
			map.remove(id);
			i +=1;
		}
	}


	
	/**
	 * @return the environment
	 */
	public Stack<Map<String, NodeLiteral>> getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(Stack<Map<String, NodeLiteral>> environment) {
		this.environment = environment;
	}
	
	
}
