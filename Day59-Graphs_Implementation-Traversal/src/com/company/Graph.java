package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

    private int v; //No of vertices
    private LinkedList<Integer>[] adj; //Adjacency Lists

    //Constructor
    @SuppressWarnings("unchecked") Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; ++i){
            adj[i] = new LinkedList<>();
        }
    }

    //A utility function to add an edge into the graph
    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    //A utility function to print BFS traversal from a given source s
    public void BFS(int s){
        //Mark all the vertices as not visited(By default set as false)
        boolean[] visited = new boolean[v];

        //Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<>();

        //Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            //Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            //Get all adjacent vertices of the dequeued vertex s
            //If an adjacent has not been visited, then mark it visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        System.out.println();
    }

    //A utility function to print DFS traversal
    private void DFSUtil(int v, boolean[] visited){
        //Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        //Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFSUtil(n, visited);
            }
        }
    }

    //The function to do DFS Traversal using recursive DFSUtil()
    public void DFS(int v){
        //Mark all the vertices as not visited (set as false by default in Java)
        boolean[] visited = new boolean[this.v];

        //Call the recursive helper function to print DFS traversal
        DFSUtil(v, visited);
    }
}
