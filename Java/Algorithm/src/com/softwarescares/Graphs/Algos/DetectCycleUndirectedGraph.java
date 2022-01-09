package com.softwarescares;

import java.util.ArrayList;

public class DetectCycleUndirectedGraph
{
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;

    public DetectCycleUndirectedGraph(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    // A function used by DFSs
    public boolean isCyclic()
    {
        //Mark all the vertices as
        // not visited
        boolean[] visited = new boolean[Vertices];

        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int i = 0; i < this.Vertices; i++)
        {
            if (!visited[i])
            {
                // Don't recur for u if already visited
                if (traversal(i, visited, -1))
                    return true;
            }
        }

        return false;
    }


    public boolean traversal(int vertice, boolean[] visited, int parent)
    {
        visited[vertice] = true;

        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes)
        {
            if (!visited[node])
            {
                if (traversal(node, visited, vertice))
                    return true;
            }
            else if (node != parent)
                return true;
        }

        return false;
    }
}
