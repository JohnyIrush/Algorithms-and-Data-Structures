package com.softwarescares;

public class TrianglesInGraph
{
    // Number of vertices in
    // the graph
    public int Vertices;

    public TrianglesInGraph(int Vertices)
    {
        this.Vertices = Vertices;
    }

    // Utility function for
    // matrix multiplication
    void multiply(int A[][], int B[][], int C[][])
    {
        for (int i = 0; i < this.Vertices; i++)
        {
            for (int j = 0; j < this.Vertices; j++)
            {
                C[i][j] = 0;
                for (int k = 0; k < this.Vertices; k++)
                {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
    }

    // Utility function to calculate
// trace of a matrix (sum of
// diagonal elements)
    int getTrace(int graph[][])
    {
        int trace = 0;

        for (int i = 0; i < this.Vertices; i++)
        {
            trace += graph[i][i];
        }
        return trace;
    }

    // Utility function for
// calculating number of
// triangles in graph
    int triangleInGraph(int graph[][])
    {
        // To Store graph^2
        int[][] aux2 = new int[this.Vertices][this.Vertices];

        // To Store graph^3
        int[][] aux3 = new int[this.Vertices][this.Vertices];

        // Initialising aux matrices
        // with 0
        for (int i = 0; i < this.Vertices; ++i)
        {
            for (int j = 0; j < this.Vertices; ++j)
            {
                aux2[i][j] = aux3[i][j] = 0;
            }
        }

        // aux2 is graph^2 now
        // printMatrix(aux2)
        multiply(graph, graph, aux2);

        // after this multiplication aux3
        // is graph^3 printMatrix(aux3)
        multiply(graph, aux2, aux3);

        int trace = getTrace(aux3);

        return trace / 6;
    }
}
