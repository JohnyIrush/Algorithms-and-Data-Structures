package com.softwarescares;

import java.util.ArrayList;
import java.util.Stack;

public class Kosorajus
{
    private final int Vertices;
    private  ArrayList<ArrayList<Integer>> adjacency_list;

    public Kosorajus(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }


    public void traversal(int vertice, boolean[] visited)
    {
        visited[vertice] = true;
        System.out.print(vertice + " ");

        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes)
        {
            if (!visited[node])
                traversal(node, visited);
        }
    }

    ArrayList getTranspose()
    {
        ArrayList<ArrayList<Integer>> g = Graph.createGraph(this.Vertices);

        for (int v = 0; v < this.Vertices; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            ArrayList<Integer> nodes = adjacency_list.get(v);

            for (int node : nodes)
            {
                g.get(node).add(v);
            }
        }

        return g;
    }

    public void fillOrder(int vertice, boolean visited[], Stack stack)
    {
        // Mark the current node as visited and print it
        visited[vertice] = true;

        // Recur for all the vertices adjacent to this vertex

        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes)
        {
            if (!visited[node])
                fillOrder(node, visited, stack);
        }

        // All vertices reachable from v are processed by now,
        // push v to Stack

        stack.push(vertice);
    }


    public void printSCCs()
    {
        Stack stack = new Stack();
        //Mark all the vertices as
        // not visited
        boolean[] visited = new boolean[Vertices];

        for (int i = 0; i < this.Vertices; i++)
        {
            if (visited[i] == false)
                fillOrder(i, visited, stack);
        }

         this.adjacency_list = this.getTranspose();


        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < this.Vertices; i++)
        {
            visited[i] = false;
        }

        while (stack.empty() == false)
        {
            // Pop a vertex from stack
            int vertice = (int)stack.pop();

            // Print Strongly connected component of the popped vertex
            if (visited[vertice] == false)
            {
                this.traversal(vertice, visited);
                System.out.println();
            }
        }
    }

    public void printTransposed()
    {
        for (int i = 0; i < this.adjacency_list.size(); i++)
        {
            System.out.println("\nModified Graph" + i);
            System.out.print("head");
            for (int j = 0; j < this.adjacency_list.get(i).size(); j++)
            {
                System.out.print(" -> " + this.adjacency_list.get(i).get(j));
            }
            System.out.println();
        }
    }
}
