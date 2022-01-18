package com.softwarescares.Graphs.Algos;

public class Prims
{
    private static final int Vertices = 5;
    public int graph[][];

    public Prims(int graph[][])
    {
        //this.Vertices = graph.length;
        this.graph = graph;
    }
    public int minimumVertex(int key[], Boolean minimumSpanningTreeSet[])
    {
        int minimum = Integer.MAX_VALUE, min_index = -1;

        for (int vertex = 0; vertex < Vertices; vertex++)
        {
            if (minimumSpanningTreeSet[vertex] == false && key[vertex] < minimum)
            {
                minimum = key[vertex];
                min_index = vertex;
            }
        }

        return min_index;
    }

    // A utility function to print the constructed MST stored in
    // parent[]

    void printMinSpanningTree(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < Vertices - 1; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public void prim()
    {
        // Array to store constructed MST
        int[] parent = new int[Vertices];

        // Key values used to pick minimum weight edge in cut
        int key[] = new int[Vertices];

        // To represent set of vertices included in MST
        Boolean minimumSpanningTreeSet[] = new Boolean[Vertices];

        // Initialize all keys as INFINITE
        for (int i = 0; i < Vertices; i++)
        {
            key[i] = Integer.MAX_VALUE;
            minimumSpanningTreeSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        key[0] = 0; // Make key 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1;

        for (int count = 0; count < Vertices - 1; count++)
        {
            // Pick the minimum key vertex from the set of vertices
            // not yet included in MST
           int u = minimumVertex(key, minimumSpanningTreeSet);

            // Add the picked vertex to the MST Set
            minimumSpanningTreeSet[u] = true;

            for (int vertex = 0; vertex < Vertices; vertex++)
            {
                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is false for vertices not yet included in MST
                // Update the key only if graph[u][v] is smaller than key[v]
                if (graph[u][vertex] != 0 && minimumSpanningTreeSet[vertex] == false && graph[u][vertex] < key[vertex])
                {
                    key[vertex] = graph[u][vertex];
                    parent[vertex] = graph[u][vertex];
                }
            }

        }
        // print the constructed MST
        printMinSpanningTree(parent, graph);
    }
}
