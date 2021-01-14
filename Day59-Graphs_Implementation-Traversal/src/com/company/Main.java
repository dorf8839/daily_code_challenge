package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Creating a graph with 5 vertices
        Graph g = new Graph(4);

        //Adding edges one by one
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(2,0);
        g.addEdge(2,3);
        g.addEdge(3,3);

        System.out.println("Following is Breadth First Traversal " +
                            "(starting from vertex 2)");
        g.BFS(2);

        System.out.println("Following is Depth First Traversal " +
                            "(starting from vertex 2)");
        g.DFS(2);
    }
}
