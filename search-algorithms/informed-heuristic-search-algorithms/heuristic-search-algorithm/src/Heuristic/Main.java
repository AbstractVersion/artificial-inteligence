package Heuristic;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		// Prepare the graph
		Graph g = new Graph(7);
		
		Node n1 = new Node(1,1);
		Node n2 = new Node(1,2);
		Node n3 = new Node("Tim",3);
		Node n4 = new Node(4,4);
		Node n5 = new Node(5,5);
		Node n6 = new Node("Ali",6);
		Node n7 = new Node(7,7);
		
		n1.addNeighbours(n2);
		g.setWeights(1, 2, 10);
		n1.addNeighbours(n3);
		g.setWeights(1, 3, 2);
		
		n2.addNeighbours(n4);
		g.setWeights(2, 4, 1);
		n2.addNeighbours(n5);
		g.setWeights(2, 5, 3);
		
		
		n3.addNeighbours(n6);
		g.setWeights(3, 6, 20);
		n3.addNeighbours(n7);
		g.setWeights(3, 7, 40);
		
		List<Node> allNodes = new ArrayList<>();
		allNodes.add(n1);
		allNodes.add(n2);
		allNodes.add(n3);
		allNodes.add(n4);
		allNodes.add(n5);
		allNodes.add(n6);
		allNodes.add(n7);
		
		g.setAllNodes(allNodes);
		
		
		// Search engine
		Heuristic heuristicSearchEngine = new Heuristic();
		heuristicSearchEngine.search(g);

	}

}
