package com.softwarescares;

import java.util.ArrayList;

public class SumOfDependencies
{
    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;

    public SumOfDependencies(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    public int findSum()
    {
        int sum = 0;
        // just find the size at each vector's index
        for (int vertice = 0; vertice < this.Vertices; vertice++)
            sum += this.adjacency_list.get(vertice).size();

        return sum;
    }
}
