package IDS;

import java.util.*;

public class IDS {
	private Graph g;
	private boolean targetFound;
	
	public IDS (Graph g) {
		this.g = g;
		this.targetFound = false;
	}
	
	public void idsAlgorithm() {
		List<Node> nodeList = g.getAllNodes();
		Node root = nodeList.get(0);
		
		int depth = 0;
		
		while(this.targetFound == false) {
			System.out.println("-> Depth level = " + depth);
			dfs(root , depth);
			depth++;
		}
	}
	
	
	// Main method 
	private void dfs(Node root, int depth) {
		Stack<Node> myStack = new Stack<>();
		root.setDepthLevel(0);
		myStack.push(root);
		
		while(myStack.isEmpty() == false) {
			Node currentNode = myStack.pop();
			System.out.println("Current node: "+currentNode.getElement().toString());
			
			if(currentNode.getElement().equals(this.g.getTarget())) {
				// Target is found
				System.out.println("Target found");
				this.targetFound = true;
				return;
			}
			
			if(currentNode.getDepthLevel() >= depth) {
				continue;
			}
			
			for (int i=currentNode.getNeighbours().size()-1;i>=0;i--) {
				Node n = currentNode.getNeighbours().get(i);
				myStack.push(n);
				n.setDepthLevel(currentNode.getDepthLevel()+1);
			}
		}
		
	}
	
}











