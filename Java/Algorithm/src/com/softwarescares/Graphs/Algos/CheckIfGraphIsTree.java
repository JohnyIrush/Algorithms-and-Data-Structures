package com.softwarescares;

import java.util.ArrayList;

public class CheckIfGraphIsTree
{
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;

    public CheckIfGraphIsTree(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    // A function used by DFSs
    public boolean isTree()
    {
        //Mark all the vertices as
        // not visited
        boolean[] visited = new boolean[Vertices];

        // The call to traversal serves multiple purposes
        // It returns true if graph reachable from vertex 0
        // is cyclic. It also marks all vertices reachable
        // from 0.
        if (traversal(0, visited, -1))
            return false;

        for (int i = 0; i < this.Vertices; i++)
        {
            if (!visited[i])
                return false;
        }

        return true;
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
