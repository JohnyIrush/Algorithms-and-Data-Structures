package com.softwarescares;

import java.util.ArrayList;

public class WeightedGraph
{
    static class AdjacentListNode
    {
        int vertex;
        int weight;

        AdjacentListNode(int _v, int _w)
        {
            vertex = _v;
            weight = _w;
        }

        int getVertex(){return  vertex;}

        int getWeight(){return  weight;}
    }

    static class Graph
    {
        int Vertices; // No. of vertices

        // Pointer to an array containing adjacency lists
        ArrayList<ArrayList<AdjacentListNode>> adjacency_list;

        Graph(int Vertices)
        {
            this.Vertices = Vertices;
            adjacency_list = new ArrayList<ArrayList<AdjacentListNode>>();

            for (int vertex = 0; vertex < this.Vertices; vertex++)
            {
                adjacency_list.add(new ArrayList<AdjacentListNode>());
            }
        }

        void addEdge(int source, int vertex, int weight)
        {
            AdjacentListNode node = new AdjacentListNode(vertex, weight);
            adjacency_list.get(source).add(node); // Add v to u's list
        }
    }
}
