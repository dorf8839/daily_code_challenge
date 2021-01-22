package com.company.floydwarshall;

public class Main {

    final static int INF = 99999, V = 4;

    public static void main(String[] args) {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = {   {0,   5,  INF, 10},
                            {INF, 0,   3, INF},
                            {INF, INF, 0,   1},
                            {INF, INF, INF, 0}
        };
        AllPairShortestPath a = new AllPairShortestPath();

        // Print the solution
        a.floydWarshall(graph);
    }
}
