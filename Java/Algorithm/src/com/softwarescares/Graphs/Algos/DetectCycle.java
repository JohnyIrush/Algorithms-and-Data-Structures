package com.softwarescares;

import java.util.ArrayList;

public class DetectCycle
{
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;

    public DetectCycle(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    // A function used by DFS
    public boolean isCyclic()
    {
        //Mark all the vertices as
        // not visited
        boolean[] visited = new boolean[Vertices];
        boolean[] recStack = new boolean[Vertices];


        for (int i = 0; i < this.Vertices; i++)
        {
            if (traversal(i, visited, recStack))
                return true;
        }

        return false;
    }


    public boolean traversal(int vertice, boolean[] visited, boolean[] recStack)
    {
        if (recStack[vertice])
            return true;
        if (visited[vertice])
            return false;

        visited[vertice] = true;

        recStack[vertice] = true;


        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes)
        {
            if (traversal(node, visited, recStack))
                return true;
        }

        return true;
    }
}
