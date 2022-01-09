package com.softwarescares;

import java.util.ArrayList;
import java.util.Stack;

public class LongestPath
{
    // Pointer to an array containing adjacency lists
    ArrayList<ArrayList<WeightedGraph.AdjacentListNode>> adjacency_list;

    LongestPath(ArrayList<ArrayList<WeightedGraph.AdjacentListNode>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
    }
    public void topologicalSort(int vertex, boolean[] visited, Stack<Integer> stack)
    {
        visited[vertex] = true;


        // Recur for all the vertices adjacent to this vertex
        for (int i = 0; i<adjacency_list.get(vertex).size(); i++)
        {
            WeightedGraph.AdjacentListNode node = adjacency_list.get(vertex).get(i);
            if (!visited[node.getVertex()])
                topologicalSort(node.getVertex(), visited, stack);
        }

        stack.push(vertex);
    }

    void longestPath(int source)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int distance[] = new int[this.adjacency_list.size()];

        // Mark all the vertices as not visited
        boolean visited[] = new boolean[this.adjacency_list.size()];

        // Call the recursive helper function to store Topological
        // Sort starting from all vertices one by one

        for (int i = 0; i < this.adjacency_list.size(); i++)
        {
            if (visited[i] == false)
                topologicalSort(i, visited, stack);
        }

        // Initialize distances to all vertices as infinite and
        // distance to source as 0

        for (int i = 0; i < this.adjacency_list.size(); i++)
            distance[i] = Integer.MIN_VALUE;

        distance[source] = 0;

        while (stack.isEmpty() == false)
        {
            // Get the next vertex from topological order
            int u = stack.pop();

            if (distance[u] != Integer.MIN_VALUE)
            {
                for (int i = 0; i < adjacency_list.get(u).size(); i++)
                {
                    WeightedGraph.AdjacentListNode node = adjacency_list.get(u).get(i);

                    if (distance[node.getVertex()] < distance[u] + node.getVertex())
                        distance[node.getVertex()] = distance[u] + node.getWeight();
                }
            }
        }


        // Print the calculated longest distances
        for (int i = 0; i < adjacency_list.size(); i++)
            if(distance[i] == Integer.MIN_VALUE)
                System.out.print("INF ");
            else
                System.out.print(distance[i] + " ");
    }
}
