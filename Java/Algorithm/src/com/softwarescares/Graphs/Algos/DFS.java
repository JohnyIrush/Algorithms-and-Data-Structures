package com.softwarescares;

import java.util.ArrayList;


public class DFS {
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;

    public DFS(ArrayList<ArrayList<Integer>> adjacency_list)
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


    public void traversal(int vertice, boolean[] visited) //Time Complexity of O(V + E)
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
