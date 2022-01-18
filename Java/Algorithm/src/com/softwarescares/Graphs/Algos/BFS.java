package com.softwarescares;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFS
{
    public ArrayList<ArrayList<Integer>> adjacency_list;
    public int Vertices;
    public BFS(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }
    public  void bfs(int vertex)
    {
        //mark all vertices as not visited

        boolean[] visited = new boolean[Vertices];

        traversal(vertex, visited); // traversal utility function
    }

    public void traversal(int vertex, boolean[] visited)
    {
        LinkedList<Integer> queue = new LinkedList<>(); // create a queue - unvisited nodes

        visited[vertex] = true;
        queue.add(vertex);

        while (queue.size() != 0)
        {
            vertex = queue.poll();
            System.out.print(vertex+" ");

            ArrayList<Integer> childNodes = adjacency_list.get(vertex);

            for (int node : childNodes) {
                if (!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}
