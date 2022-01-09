package com.softwarescares;

import java.util.Arrays;

public class Kruskals
{
    private int Vertices, edges;
    Edge edge[];
    // A class to represent a graph edge
    class Edge implements Comparable<Edge>
    {
        int source, destination, weight;
        // Comparator function used for
        // sorting edgesbased on their weight
        public int compareTo(Edge compareEdge)
        {
            return this.weight - compareEdge.weight;
        }
    };

    // A class to represent a subset for
    // union-find

    class subset
    {
        int parent, rank;
    };

    Kruskals(int vertices, int edges)
    {
        Vertices = vertices;
        this.edges = edges;
        edge = new Edge[this.edges];

        for (int i = 0; i < edges; ++i)
            edge[i] = new Edge();
    }

    // A utility function to find set of an
    // element i (uses path compression technique)

    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i
        // (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    void union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root
        // of high rank tree (Union by Rank)

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        // If ranks are same, then make one as
        // root and increment its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void kruskal()
    {
        Edge result[] = new Edge[Vertices];
        int e = 0;
        int i = 0;

        for (int j = 0; j < Vertices; j++)
            result[j] = new Edge();

        Arrays.sort(edge);

        // Allocate memory for creating V subsets
        subset subsets[] = new subset[Vertices];
        for (i = 0; i < Vertices; ++i)
            subsets[i] = new subset();

        // Create V subsets with single elements
        for (int v = 0; v < Vertices; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0; // Index used to pick next edge

        while (e < Vertices - 1)
        {
            Edge next_edge = edge[i++];

            int x = find(subsets, next_edge.source);
            int y = find(subsets, next_edge.destination);

            // If including this edge does't cause cycle,
            // include it in result and increment the index
            // of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                union(subsets, x, y);
            }

        }
        // print the contents of result[] to display
        // the built MST
        System.out.println("Following are the edges in "
                + "the constructed MST");
        int minimumCost = 0;
        for (i = 0; i < e; ++i)
        {
            System.out.println(result[i].source + " -- "
                    + result[i].destination
                    + " == " + result[i].weight);
            minimumCost += result[i].weight;
        }
        System.out.println("Minimum Cost Spanning Tree "
                + minimumCost);
    }
}
