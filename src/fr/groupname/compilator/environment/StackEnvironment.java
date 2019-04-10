package fr.groupname.compilator.environment;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import ubordeaux.deptinfo.compilation.project.node.NodeId;
import ubordeaux.deptinfo.compilation.project.node.NodeLiteral;
import ubordeaux.deptinfo.compilation.project.type.IdentifierList;
import ubordeaux.deptinfo.compilation.project.type.Type;


//Local variable stack
public class StackEnvironment {
	//private IdentifierList environment_int_var_id;
	//private IdentifierList environment_bool_var_id;
	//private IdentifierList environment_str_var_id;
	//private Stack<List<NodeLiteral>> environment_variable_value;	//Map de nodeId, NodeLiteral en fait
	private Stack<Map<NodeId, NodeLiteral>> environment;

	public StackEnvironment() {
		//environment_variable_value = new Stack<>();
		
		environment = new Stack<>();
		
	}
	
	//Input: "local variables stack"
	public StackEnvironment(String str) {
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


	/*
	public void new_portability(NodeLiteral first) {
		List<NodeLiteral> array = new ArrayList<>();
		array.add(first);
		environment_variable_value.push(array);
	}*/
	
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
