package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import ubordeaux.deptinfo.compilation.project.node.NodeId;
import ubordeaux.deptinfo.compilation.project.node.NodeLiteral;
import ubordeaux.deptinfo.compilation.project.type.IdentifierList;
import ubordeaux.deptinfo.compilation.project.type.Type;


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
	
	/*
	//haut vers bas, faut get le last equals sinon modifier et utiliser listIterator+hasPrevious
	public Node get_node_reachable(Node cmp) throws NoSuchFieldException {
		Iterator<List<NodeLiteral>> it = environment_variable_value.iterator();
		while(it.hasNext()) {
			List<NodeLiteral> list = it.next();
			
			for(Node n : list) {
				if (n.equals(cmp))
					return n;
				
			}
		}
		throw new NoSuchFieldException("Aucune variable similaire stackee trouvee");
			
	}
	*/
	
	
	public void add_node_to_latest_portability(String id, NodeLiteral n) {
		System.out.println("* Enregistre " + id.toString());
		this.get_last_portability().put(id, n);
	}


	public NodeLiteral getLiteralFromId(String id) throws NoSuchFieldException {
		NodeLiteral res = environment.peek().get(id);
		if(res == null)
			throw new NoSuchFieldException("[ERROR]Aucune variable similaire stackee trouvee"+"\n[ERROR]Stack Layer:"+environment.size());
		return res;
		
		/*
		for(Entry<String, NodeLiteral> entry : environment.peek().entrySet()) {
			if(entry.getKey().getName() == id)
				return entry.getValue();
		}
		*/

		//throw new NoSuchFieldException("Count:"+environment.size()+ "[ERROR]Aucune variable similaire stackee trouvee");
	}
	
	/*
	public Type getTypeFromId(String id) throws NoSuchFieldException {
		for(Entry<NodeId, NodeLiteral> entry : environment.peek().entrySet()) {
			System.out.println("Key: " + entry.getKey().getName());
			if(entry.getKey().getName() == id)
				return entry.getValue().getType();
		}

		throw new NoSuchFieldException("Count:"+environment.size()+ "[ERROR]Aucune variable similaire stackee trouvee");
	}
*/
	
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
