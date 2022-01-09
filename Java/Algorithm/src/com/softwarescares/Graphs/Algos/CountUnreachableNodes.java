package com.softwarescares;

import java.util.ArrayList;

public class CountUnreachableNodes
{
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;

    public CountUnreachableNodes(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    // A function used by DFS
    public int countUnreachable(int vertice)
    {
        //Mark all the vertices as
        // not visited
        boolean[] visited = new boolean[Vertices];

        traversal(vertice, visited);

        int count = 0;
        for (int i = 0; i < this.Vertices; i++)
        {
            if (visited[i] == false)
                count++;
        }

        return count;

    }


    public void traversal(int vertice, boolean[] visited)
    {
        visited[vertice] = true;
        System.out.print(vertice + " ");

        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes) {
            if (!visited[node])
                traversal(node, visited);
        }
    }
}
