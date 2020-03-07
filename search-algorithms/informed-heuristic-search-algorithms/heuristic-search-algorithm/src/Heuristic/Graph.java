package Heuristic;

import java.util.*;

public class Graph {
	private List<Node> allNodes;
	private int nodeMaxNo;
	private double[][] weights;
	
	public Graph(int n) {
		this.allNodes = new ArrayList<>();
		this.nodeMaxNo = n;
		this.weights = new double[this.nodeMaxNo][this.nodeMaxNo];
	}

	public List<Node> getAllNodes() {
		return allNodes;
	}

	public void setAllNodes(List<Node> allNodes) {
		this.allNodes = allNodes;
	}

	public double getWeights(int rowNo, int colNo) {
		return this.weights[rowNo][colNo];
	}

	public void setWeights(int colNo, int rowNo, double value) {
		this.weights[colNo - 1] [rowNo -1 ] = value;
		this.weights[rowNo - 1] [colNo -1 ] = value;
	}
	
	
	
}
