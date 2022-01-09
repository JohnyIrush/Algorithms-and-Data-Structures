package com.softwarescares;

import java.util.ArrayList;

public class MotherVertex
{
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;

    public MotherVertex(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    // A function used by DFS
    public void dfs(int vertice)
    {
        //Mark all the vertices as
        // not visited
        boolean[] visited = new boolean[Vertices];

        traversal(vertice, visited);

    }


    public void traversal(int vertice, boolean[] visited)
    {
        visited[vertice] = true;

        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes)
        {
            if (!visited[node])
                traversal(node, visited);
        }
    }

    public int motherVertex()
    {
        boolean[] visited = new boolean[this.Vertices];

        int v = -1;

        for (int i = 0; i < this.Vertices; i++)
        {
            if (!visited[i])
            {
                this.traversal(i, visited);
                v = i;
            }
        }

        boolean[] check = new boolean[this.Vertices];

        traversal(v, check);

        for (boolean val :  check)
        {
            if (!val)
            {
                return  -1;
            }
        }

        return v;
    }
}
