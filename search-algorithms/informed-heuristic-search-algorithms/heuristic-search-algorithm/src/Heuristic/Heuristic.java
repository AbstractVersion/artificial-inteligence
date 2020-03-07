package Heuristic;

import java.util.*;

public class Heuristic {

	public void search(Graph g) {
		List<Node> nodeList = g.getAllNodes();
		Node root = nodeList.get(0);
		
		List<Node> neighbours = null;
		
		do {
			neighbours = root.getNeighbours();
			System.out.println(root.getElement().toString());
			
			double min = Integer.MAX_VALUE;
			int idx = 1; // Index of the best neighbour
			for (Node n : neighbours) {
				double cost = g.getWeights( root.getIndex() - 1 , 
						                    n.getIndex() - 1);
				
				if (cost < min) {
					min = cost;
					idx = n.getIndex();
				}
			}
			
			root = nodeList.get(idx-1);
			
		}while ( neighbours.isEmpty() == false );
		
		
	}
	
}
