package com.softwarescares;

        import java.util.*;

public class DirectedGraph
{

    public static ArrayList<ArrayList<Integer>> adjacency_list;

    // Create Graph

    static void createGraph(int Vertices)
    {

        adjacency_list = new ArrayList<>();

        for (int i = 0; i < Vertices; i++)
        {
            adjacency_list.add(new ArrayList<>());
        }

    }

    // A utility function to add
    // edge in an undirected graph
    static void addEdge(int source, int vertex)
    {
        adjacency_list.get(source).add(vertex);
    }

    // A utility function to print the adjacency
    // list representation of graph

    static  void printGraph()
    {
        for (int i = 0; i < adjacency_list.size(); i++)
        {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adjacency_list.get(i).size(); j++)
            {
                System.out.print(" -> " + adjacency_list.get(i).get(j));
            }
            System.out.println();
        }
    }

}

