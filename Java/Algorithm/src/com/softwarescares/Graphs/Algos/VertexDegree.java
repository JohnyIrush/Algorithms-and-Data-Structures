package com.softwarescares;

public class VertexDegree
{
    public static void findDegree(int adjacency_matrix[][], int vertex)
    {
        int degree = 0;
        for (int i = 0; i < adjacency_matrix.length; i++)
            if (adjacency_matrix[vertex][i] == 1)
                degree++;

        if (adjacency_matrix[vertex][vertex] == 1) degree++;

        System.out.println(degree);
    }
}
