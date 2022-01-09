package com.softwarescares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class TopologicalSort
{
    public int Vertices;
    public  ArrayList<ArrayList<Integer>> adjacency_list;

    public TopologicalSort(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }
    public void topologicalSort()
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[Vertices];
        for (int i = 0; i < Vertices; i++)
            visited[i] = false;

        for (int i = 0; i < Vertices; i++)
        {
            if (visited[i] == false)
                traversal(i, visited, stack);
            if (i == 1)
            {
                // System.out.println(Arrays.toString(visited));
                // System.out.println(stack.toString());
                // return;
            }
        }

        while (stack.empty() == false)
            System.out.print(stack.pop() + " ");
    }

    public void traversal(int vertice, boolean[] visited, Stack<Integer> stack)
    {
        visited[vertice] = true;


        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes)
        {
            if (!visited[node])
                traversal(node, visited, stack);
        }

        stack.push(vertice);
    }
}
