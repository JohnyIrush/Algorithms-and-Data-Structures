package com.softwarescares;

public class BellmanFordTwo
{
    class Edge
    {
        int source, destination, weight;
        Edge()
        {
            source = destination = weight = 0;
        }
    };

    int Vertices, Edges;
    Edge edge[];

    BellmanFordTwo(int v, int e)
    {
        Vertices = v;
        Edges = e;
        edge = new Edge[e];
        for (int i = 0; i < e; i++)
            edge[i] = new Edge();
        int V = graph.Vertices, E = graph.Edges;
    }

    void bellmanFord(BellmanFordTwo graph, int source)
    {
        int distance[] = new int[Vertices];

        for (int i = 0; i < Vertices; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[source] = 0; // [0,-1,4,inf,inf]

        for (int i = 0; i < V; i++)
        {
            for (int j = 0; j < E; j++)
            {
                int u = graph.edge[j].source;
                int v = graph.edge[j].destination;
                int weight = graph.edge[j].weight;
                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v])
                    distance[v] = distance[u] + weight;
            }
        }

        for (int j = 0; j < E; ++j) {
            int u = graph.edge[j].source;
            int v = graph.edge[j].destination;
            int weight = graph.edge[j].weight;
            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(distance, V);
    }

    // A utility function used to print the solution
    void printArr(int dist[], int V)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {

        //-- Bellman Ford

        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        BellmanFordTwo graph = new BellmanFordTwo(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edge[0].source = 0;
        graph.edge[0].destination = 1;
        graph.edge[0].weight = -1;

        // add edge 0-2 (or A-C in above figure)
        graph.edge[1].source = 0;
        graph.edge[1].destination = 2;
        graph.edge[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edge[2].source = 1;
        graph.edge[2].destination = 2;
        graph.edge[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edge[3].source = 1;
        graph.edge[3].destination = 3;
        graph.edge[3].weight = 2;

        // add edge 1-4 (or B-E in above figure)
        graph.edge[4].source = 1;
        graph.edge[4].destination = 4;
        graph.edge[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edge[5].source = 3;
        graph.edge[5].destination = 2;
        graph.edge[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edge[6].source = 3;
        graph.edge[6].destination = 1;
        graph.edge[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edge[7].source = 4;
        graph.edge[7].destination = 3;
        graph.edge[7].weight = -3;

        graph.bellmanFord(graph, 0);


        /*
        List<Vertex> vertexList = new ArrayList<>();

        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));
        edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(2)));
        edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(2)));

        BellmanFord bellmanFord = new BellmanFord(edgeList, vertexList);
        bellmanFord.bellmanFord(vertexList.get(0));
        bellmanFord.shortestPathTo(vertexList.get(2));
         */
    }
    
}
