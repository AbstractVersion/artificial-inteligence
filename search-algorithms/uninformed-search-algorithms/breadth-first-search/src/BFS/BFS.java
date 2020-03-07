/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author onelove
 */
public class BFS {

    //Atributes
    private Queue<Node> myyQueue;
    
    public BFS() {
        this.myyQueue = new LinkedList<>();
    }
    
    public void bfs(Graph g) {
        List<Node> nodeList = g.getAllNodes();
        
        for (Node n : nodeList) {
            if (n.isVisited() == false) {
                n.setVisited(true);
                bfsInQueue(n);
            }
        }
    }
    //every time you call this function, this ellement will be a root. Not a generall root but a local one.
    private void bfsInQueue(Node root) {
        this.myyQueue.add(root);
        root.setVisited(true);
        
        while(this.myyQueue.isEmpty() == false){
            Node currentNode = this.myyQueue.remove();
            System.out.println("Current node : " + currentNode.getElement().toString());
            
            for(Node n : currentNode.getNeighbors()){
                if (n.isVisited() == false) {
                    n.setVisited(true);
                    this.myyQueue.add(n);
                }
            }
        }
    }
}
