package com.softwarescares;

import java.util.ArrayList;

public class Bridges
{
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;
    int time = 0;
    static final int NIL = -1;

    public Bridges(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    // DFS based function to find all bridges. It uses recursive
    // function traversal()
    public void bridge()
    {
        //Mark all the vertices as
        // not visited
        boolean[] visited = new boolean[Vertices];
        int disc[] = new int[Vertices];
        int low[] = new int[Vertices];
        int parent[] = new int[Vertices];

        for (int i = 0; i < Vertices; i++)
        {
            parent[i] = NIL;
            visited[i] = false;
        }

        // Call the recursive helper function to find Bridges
        // in DFS tree rooted with vertex 'i'
        for (int i = 0; i < Vertices; i++)
        {
            if (visited[i] == false)
                traversal(i, visited, disc, low, parent);
        }
    }


    public void traversal(int vertice, boolean[] visited, int disc[], int low[], int parent[])
    {
        // Mark the current node as visited
        visited[vertice] = true;

        // Initialize discovery time and low value
        disc[vertice] = low[vertice] = ++time; // disc["0" => 1, "1" => 2, "2" => 3, "3" => 4, "4" => 5], low["0" => 1, "1" => 2,  "2" => 1, "3" => 1, "4" => 5] time = 4

        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes)
        {
            // If v is not visited yet, then make it a child
            // of u in DFS tree and recur for it.
            // If v is not visited yet, then recur for it
            if (!visited[node])
            {
                parent[node] = vertice; // ["1" => 0, "3" => 4]
                traversal(node, visited, disc, low, parent);

                low[vertice] = Math.min(low[node], low[vertice]);

                // If the lowest vertex reachable from subtree
                // under v is below u in DFS tree, then u-v is
                // a bridge
                if (low[node] > disc[vertice])
                    System.out.println(vertice+" "+node);
            }

            // Update low value of u for parent function calls.
            else if (node != parent[vertice])
                low[vertice] = Math.min(low[node], low[vertice]);
        }
    }
}
