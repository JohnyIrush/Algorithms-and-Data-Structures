package com.softwarescares;

public class Dijkstra
{
    public int Vertices;
    public int graph[][];

    public Dijkstra(int graph[][])
    {
        this.graph = graph;
        this.Vertices = graph.length;
    }

    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree

    public int minDistance(int distance[], Boolean shortestPathTreeSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int vertice = 0; vertice < this.Vertices; vertice++)
        {
            if (shortestPathTreeSet[vertice] == false && distance[vertice] <= min)
            {
                min = distance[vertice];
                min_index = vertice;
            }
        }
        return min_index;
    }

    // A utility function to print the constructed distance array

    public void printSolution(int distance[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int vertice = 0; vertice < this.Vertices; vertice++)
        {
            System.out.println(vertice + " \t\t " + distance[vertice]);
        }
    }

    public void dijkstra(int source)
    {
        int distance[] = new int[this.Vertices]; // The output array. dist[i] will hold
        // the shortest distance from source to vertice

        // shortestPathTreeSet[vertice] will true if vertex is included in shortest
        // path tree or shortest distance from source to vertice is finalized
        Boolean shortestPathTreeSet[] = new Boolean[this.Vertices];

        for (int vertice = 0; vertice < this.Vertices; vertice++)
        {
            distance[vertice]  = Integer.MAX_VALUE;
            shortestPathTreeSet[vertice] = false;
        }

        // Distance of source vertex from itself is always 0
        distance[source] = 0;

        for (int count = 0; count < this.Vertices - 1; count++)
        {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = this.minDistance(distance, shortestPathTreeSet);

            // Mark the picked vertex as processed
            shortestPathTreeSet[u] = true;

            for (int v = 0; v < this.Vertices; v++)
            {
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!shortestPathTreeSet[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v])
                   distance[v] = distance[u] + graph[u][v];
            }
        }

        // print the constructed distance array
        printSolution(distance);

    }


}
