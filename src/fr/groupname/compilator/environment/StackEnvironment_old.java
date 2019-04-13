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
public class StackEnvironment_old {
	private Stack<Map<NodeId, NodeLiteral>> environment;

	public StackEnvironment_old() {		
		environment = new Stack<>();
		
	}
	
	//Input: "local variables stack"
	public StackEnvironment_old(String str) {
		this();
	}
	
	public Map<NodeId, NodeLiteral> get_last_portability(){
		if(environment.isEmpty())
			return environment.push(new HashMap<NodeId, NodeLiteral>());
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
	
	public void add_identifier_node_list(IdentifierList id_list, Type t) throws ClassNotFoundException {
		//TODO
		throw new ClassNotFoundException("Cannot save this identifier for type: " + t);
	}
	
	public boolean is_existing_variable(NodeId n) {
		//TODO
		return true;
	}
	
	
	public void add_node_to_latest_portability(NodeId id, NodeLiteral n) {
		System.out.println("* Enregistre " + id.toString());
		this.get_last_portability().put(id, n);
	}

	public NodeLiteral getLiteralFromId(NodeId id) {
		return environment.peek().get(id);
	}

	public NodeLiteral getLiteralFromId(String id) throws NoSuchFieldException {
		for(Entry<NodeId, NodeLiteral> entry : environment.peek().entrySet()) {
			if(entry.getKey().getName() == id)
				return entry.getValue();
		}

		throw new NoSuchFieldException("Count:"+environment.size()+ "[ERROR]Aucune variable similaire stackee trouvee");
	}
	
	public Type getTypeFromId(String id) throws NoSuchFieldException {
		for(Entry<NodeId, NodeLiteral> entry : environment.peek().entrySet()) {
			System.out.println("Key: " + entry.getKey().getName());
			if(entry.getKey().getName() == id)
				return entry.getValue().getType();
		}

		throw new NoSuchFieldException("Count:"+environment.size()+ "[ERROR]Aucune variable similaire stackee trouvee");
	}
	
	/**
	 * @return the environment
	 */
	public Stack<Map<NodeId, NodeLiteral>> getEnvironment() {
		return environment;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(Stack<Map<NodeId, NodeLiteral>> environment) {
		this.environment = environment;
	}
	
	
}
