/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BFS;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author onelove
 */
public class Node {

    //Attributes of class Node
    private Object element; //the element itself of the node might be int string etc...
    private boolean visited; //if the node is visited
    private List<Node> neighbors; //neighbors of the current node
    
    //Methods
    public Node(Object obj) {
        neighbors = new ArrayList<>();
        this.element = obj;
        this.visited = false;
    }
    
    public boolean isVisited(){
        return this.visited;
    }
    
    public void addNeighbour(Node obj){
        this.neighbors.add(obj);
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }
    
    
    
}
