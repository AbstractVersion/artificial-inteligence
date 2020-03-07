package PathFinding_GA;

import java.util.*;

import javax.swing.JFrame;

public class FitnessFunction {
	public static boolean showPath = false; 
	
	public static double evaluate(Object[] genes) {
		//new
		
		
		Maze maze = new Maze();
		Graph g = maze.getGraph();
		
		int sizeArray = genes.length;
		
		int[] decimalArray = new int[sizeArray];
		
		int idx = 0;
		
		for(int i = 0 ; i < genes.length; i+=2) {
			if((int)genes[i] == 0 && (int)genes[i+1]==0) {
				decimalArray[idx] = 0;
			}
			
			if((int)genes[i] == 0 && (int)genes[i+1]==1) {
				decimalArray[idx] = 1;
			}
			
			if((int)genes[i] == 1 && (int)genes[i+1]==0) {
				decimalArray[idx] = 2;
			}
			
			if((int)genes[i] == 1 && (int)genes[i+1]==1) {
				decimalArray[idx] = 3;
			}
			
			idx++;
		}
		
		List<Node> nodeList = g.getAllNodes();
		List<Node> neighbours = null;
		List<Node> nodeVisited = new ArrayList<>();
		int startNodeNumber = maze.getStartingPoint()-1;
		Node root = nodeList.get( startNodeNumber);
		
		
		for(int i = 0 ; i < decimalArray.length; i++) {
			nodeVisited.add(root);
			root.setVisited(true);
			neighbours = root.getNeighbours();
			if (neighbours.isEmpty()) {
				break;
			}
			
			if (decimalArray[i] == 1) {
				if(neighbours.get(0).isVisited() == false) {
					root = neighbours.get(0);
				}
				
			}
			else if(neighbours.size()>=2 && decimalArray[i] == 2) {
				if(neighbours.get(1).isVisited() == false) {
					root = neighbours.get(1);
				}
			}
			else if(neighbours.size()>=3 && decimalArray[i] == 3) {
				if(neighbours.get(2).isVisited() == false) {
					root = neighbours.get(2);
				}		
			}
			else if(neighbours.size()>=4 && decimalArray[i] == 4) {
				if(neighbours.get(3).isVisited() == false) {
					root = neighbours.get(3);
				}
			}
			
		}
		 
		
		double sum = Math.abs((int) root.getElement() - maze.getTargetPoint()  );
		
		// new
		if (sum == 0 || showPath == true) { // new
			
			drawPath(maze, nodeVisited);  // new
			 
		} // new
		 
		

		 
		
		
		return sum;
	}
	
	public static void drawPath(Maze maze, List<Node> nodeVisited) {
		
		//Draw the path obtained by GA
		JFrame f2 = new JFrame("Path");
		f2.setSize(1000, 1000);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FinalPath finalPath = new FinalPath(maze, nodeVisited);
		
		f2.add(finalPath);
		f2.setVisible(true);
	}
}
