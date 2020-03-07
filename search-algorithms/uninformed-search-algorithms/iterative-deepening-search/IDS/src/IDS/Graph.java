package IDS;

import java.util.*;

public class Graph {
	private List<Node> allNodes;
	private Object target;
	
	public Graph() {
		this.allNodes = new ArrayList<>();
	}

	public List<Node> getAllNodes() {
		return allNodes;
	}

	public void setAllNodes(List<Node> allNodes) {
		this.allNodes = allNodes;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
	
	
}
