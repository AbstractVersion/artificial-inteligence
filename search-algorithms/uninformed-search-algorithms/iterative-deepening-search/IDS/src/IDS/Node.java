package IDS;

import java.util.*;

public class Node {
	
	private Object element;
	private boolean visted;
	private List<Node> neighbours;
	private int depthLevel;
	
	public Node(Object e) {
		this.element = e;
		this.neighbours = new ArrayList<>();
		this.depthLevel = 0;
	}
	
	public boolean isVisted() {
		return this.visted;
	}
	
	public void addNeighbour(Node n) {
		this.neighbours.add(n);
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<Node> neighbours) {
		this.neighbours = neighbours;
	}

	public int getDepthLevel() {
		return depthLevel;
	}

	public void setDepthLevel(int depthLevel) {
		this.depthLevel = depthLevel;
	}

	public void setVisted(boolean visted) {
		this.visted = visted;
	}
	
	
	
}
