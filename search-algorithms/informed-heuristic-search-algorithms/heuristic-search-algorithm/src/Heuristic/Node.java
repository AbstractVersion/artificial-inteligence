package Heuristic;

import java.util.*;

public class Node {

	private Object element;
	private boolean visted;
	private List<Node> neighbours;
	private int index;
	
	public Node(Object element, int index) {
		this.element = element;
		this.index = index;
		this.neighbours = new ArrayList<>();
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public boolean isVisted() {
		return visted;
	}

	public void setVisted(boolean visted) {
		this.visted = visted;
	}

	public List<Node> getNeighbours() {
		return neighbours;
	}

	public void addNeighbours(Node n) {
		this.neighbours.add(n);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
}
