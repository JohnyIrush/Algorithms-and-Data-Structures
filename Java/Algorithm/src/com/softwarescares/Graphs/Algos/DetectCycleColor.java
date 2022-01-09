package com.softwarescares;

import java.util.ArrayList;

public class DetectCycleColor
{
    // A DFS based approach to find if there is a cycle
    // in a directed graph. This approach strictly follows
    // the algorithm given in CLRS book.
    public static int WHITE = 0, GRAY = 1, BLACK = 2;

    private final int Vertices;
    private final ArrayList<ArrayList<Integer>> adjacency_list;

    public DetectCycleColor(ArrayList<ArrayList<Integer>> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
        this.Vertices = adjacency_list.size();
    }

    // A function used by DFS
    public boolean isCyclic()
    {
        //Mark all the vertices as
        // not visited
        int[] color = new int[Vertices];

        for (int i = 0; i < this.Vertices; i++)
        {
            color[i] = WHITE;
        }

        // Do a DFS traversal beginning with all
        // vertices

        for (int i = 0; i < this.Vertices; i++)
        {
            if (color[i] == WHITE)
            {
                if (traversal(i, color))
                    return true;
            }
        }

        return false;
    }


    public boolean traversal(int vertice, int[] color)
    {
        // GRAY : This vertex is being processed (DFS
        // for this vertex has started, but not
        // ended (or this vertex is in function
        // call stack)
        color[vertice] = GRAY;

        // Iterate through all adjacent vertices
        ArrayList<Integer> childNodes = adjacency_list.get(vertice);

        for (int node : childNodes)
        {
            if (color[node] == GRAY)
            {
                return true;
            }

            // If v is not processed and there is a back
            // edge in subtree rooted with v
            if (color[node] == WHITE && traversal(node, color) == true)
                return  true;
        }

        // Mark this vertex as processed
        color[vertice] = BLACK;
        return true;
    }

}
