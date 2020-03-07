package BFS;

import BFS.Node;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author onelove
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    
    /*
    The tree we create 
            1
          /   \
        2       3
      /   \   /   \
     4    5  6     7
    */
    private static List<Node> initializeNodeLst() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        //adding n1 neighbors
        n1.addNeighbour(n2);
        n1.addNeighbour(n8);
        n1.addNeighbour(n3);
        //adding n2 neighbors
        n2.addNeighbour(n4);
        n2.addNeighbour(n5);
        //adding n3 neighbours
        n2.addNeighbour(n6);
        n2.addNeighbour(n7);

        List<Node> tempList = new ArrayList<>();
        tempList.add(n1);
        tempList.add(n2);
        tempList.add(n3);
        tempList.add(n4);
        tempList.add(n5);
        tempList.add(n6);
        tempList.add(n7);
        return tempList;
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        List<Node> nodeList = initializeNodeLst();
        g.setAllNodes(nodeList);
        BFS bfsSearchEngine = new BFS();
        bfsSearchEngine.bfs(g);
    }

}
