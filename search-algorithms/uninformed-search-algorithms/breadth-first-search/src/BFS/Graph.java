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
public class Graph {

    //Atributes
    private List<Node> allNodes; //graph nodes

    public Graph() {
        this.allNodes = new ArrayList<>();
    }

    public void setAllNodes(List<Node> allNodes) {
        this.allNodes = allNodes;
    }

    public List<Node> getAllNodes() {
        return allNodes;
    }
    
    

}
