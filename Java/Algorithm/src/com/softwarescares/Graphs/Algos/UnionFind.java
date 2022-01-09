package com.softwarescares;

import java.util.ArrayList;

public class UnionFind
{
    public  int Vertices, Edges;
    public Edge edge[];

    class Edge
    {
        int source, destination;
    };

    public UnionFind(int Vertices, int Edges)
    {
        this.Vertices = Vertices;
        this.Edges = Edges;
        edge = new Edge[Edges];

        for (int i = 0; i < Edges; i++)
        {
            edge[i] = new Edge();
        }
    };

    // A utility function to find the subset of an element i

    public int find(int parent[], int i)
    {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    // A utility function to do union of two subsets
    public void Union(int parent[], int x, int y)
    {
        parent[x] = y;
    }

    // The main function to check whether a given graph
    // contains cycle or not

    public int isCycle(UnionFind graph)
    {
        // Allocate memory for creating V subsets
        int parent[] = new int[graph.Vertices];

        for (int i = 0; i < graph.Vertices; i++)
        {
            parent[i] = -1;

        }

        for (int i = 0; i < graph.Edges; i++)
        {
            int x = graph.find(parent, graph.edge[i].source);
            int y = graph.find(parent, graph.edge[i].destination);
            if (x == y)
                return 1;

            graph.Union(parent, x, y);
        }

        return 0;
    }


}
