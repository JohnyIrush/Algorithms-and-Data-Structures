package com.softwarescares;

import java.util.ArrayList;
import java.util.Stack;

public class IterativeDFS
{
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;

    public IterativeDFS(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    // A function used by DFS
    public void dfs(int vertice)
    {
        //Mark all the vertices as
        // not visited
        boolean[] visited = new boolean[Vertices];

        Stack<Integer> stack = new Stack<>();

        stack.push(vertice);

        while(stack.empty() == false)
        {
            vertice = stack.pop();

            if (visited[vertice] == false)
            {
                System.out.print(vertice + " ");
                visited[vertice] = true;
            }

            ArrayList<Integer> childNodes = adjacency_list.get(vertice);

            for (int node : childNodes)
            {
                if (!visited[node])
                    stack.push(node);
            }
        }
    }

}
