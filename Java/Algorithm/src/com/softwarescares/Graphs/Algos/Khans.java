package com.softwarescares;

import java.util.*;

public class Khans
{
    public int Vertices;
    public  ArrayList<ArrayList<Integer>> adjacency_list;

    public Khans(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    public void topologicalSort()
    {
        // Create a array to store
        // indegrees of all
        // vertices. Initialize all
        // indegrees as 0.

        int indegree[] = new int[this.Vertices];

        // Traverse adjacency lists
        // to fill indegrees of
        // vertices. This step takes
        // O(V+E) time
        computeIndegree(indegree);

        // Create a queue and enqueue
        // all vertices with indegree 0

        Queue<Integer> queue = new LinkedList<>();

        for (int vertice = 0; vertice < this.Vertices; vertice++)
            if (indegree[vertice] == 0)
                queue.add(vertice);
        // Initialize count of visited vertices
        int count = 0;

        Vector<Integer> topologicalOrder = new Vector<Integer>();

        // Create a vector to store result
        // (A topological ordering of the vertices)

        while (!queue.isEmpty())
        {
            // Extract front of queue
            // (or perform dequeue)
            // and add it to topological order
            int u = queue.poll();
            topologicalOrder.add(u);

            // Iterate through all its
            // neighbouring nodes
            // of dequeued node u and
            // decrease their in-degree
            // by 1

            ArrayList<Integer> childNodes = adjacency_list.get(u);
            for (int node : childNodes)
                if (--indegree[node] == 0)
                    queue.add(node);
            count++;
        }

        if (count != this.Vertices)
        {
            System.out.println(
                    "There exists a cycle in the graph");
            return;
        }

        printTopologicalOrder(topologicalOrder);
    }

    private void printTopologicalOrder(Vector<Integer> topologicalOrder)
    {
        for (int i : topologicalOrder)
            System.out.print(i + " ");
    }

    public void computeIndegree(int[] indegree)
    {
        for (int vertice = 0; vertice < this.Vertices; vertice++)
        {
            ArrayList<Integer> childNodes = adjacency_list.get(vertice);
            for (int node : childNodes)
                indegree[node]++;
        }
    }


}
