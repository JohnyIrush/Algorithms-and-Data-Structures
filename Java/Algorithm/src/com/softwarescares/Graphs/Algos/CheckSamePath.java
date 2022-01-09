package com.softwarescares;

import java.util.ArrayList;

public class CheckSamePath
{
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;
    public static int MAX = 100001;
    
    public static int []intime = new int[MAX];
    public static int []outtime = new int[MAX];

    public static int timer = 0;

    public CheckSamePath(ArrayList<ArrayList<Integer>> adjacency_list)
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

        ++timer;
        // System.out.print(vertice + " ");
        intime[vertice] = timer;

        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes) {
            if (!visited[node])
                traversal(node, visited);
        }

        ++timer;

        outtime[vertice] = timer;
    }

    public static boolean query(int u, int v)
    {
        return ((intime[u] < intime[v] &&
                outtime[u] > outtime[v]) ||
                (intime[v] < intime[u] &&
                        outtime[v] > outtime[u]));
    }
}
