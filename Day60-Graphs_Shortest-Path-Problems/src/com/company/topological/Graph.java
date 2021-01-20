package com.company.topological;

import java.util.ArrayList;
import java.util.Stack;

//This class represents a directed graph using adjacency list representation
public class Graph {
    //No. of vertices
    private int V;

    //Adjacency List as ArrayList of ArrayLists
    private ArrayList<ArrayList<Integer>> adj;

    //Constructor

    public Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for(int i = 0; i < v; ++i){
            adj.add(new ArrayList<>());
        }
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w){
        adj.get(v).add(w);
    }

    //A recursive function used by topologicalSort
    void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack){
        //Mark the current node as visited
        visited[v] = true;
        Integer i;

        //Recur for all the vertices adjacent to this vertex
        for (Integer integer : adj.get(v)) {
            i = integer;
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        //Push current vertex to stack which stores result
        stack.push(v);
    }

    //The function to do Topological Sort.
    //It uses recursive topologicalSortUtil()
    void topologicalSort(){
        Stack<Integer> stack = new Stack<>();
        //Mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            visited[i] = false;
        }

        //Call the recursive helper function to store Topological
        //Sort starting from all vertices one by one
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                topologicalSortUtil(i, visited, stack);
            }
        }

        //Print contents of stack
        while(!stack.empty()){
            System.out.print(stack.pop() + " ");
        }
    }
}
