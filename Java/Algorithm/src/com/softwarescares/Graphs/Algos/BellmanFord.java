package com.softwarescares;

import java.util.List;

public class BellmanFord
{
    private List<com.softwarescares.Edge> edgeList;
    private List<com.softwarescares.Vertex> vertexList;

    public BellmanFord(List<com.softwarescares.Edge> edgeList, List<com.softwarescares.Vertex> vertexList)
    {
        this.edgeList = edgeList;
        this.vertexList = vertexList;
    }

    public void bellmanFord(com.softwarescares.Vertex source)
    {
        source.setDistance(0);

        for (int i = 0; i < vertexList.size() - 1; i++) // Relaxation
        {
            for (com.softwarescares.Edge edge : edgeList)
            {
                com.softwarescares.Vertex u = edge.getStart();
                com.softwarescares.Vertex v = edge.getTarget();
                if (u.getDistance() == Double.MAX_VALUE) continue;

                double newDistance = u.getDistance() + edge.getWeight();

                if (newDistance < v.getDistance())
                {
                    v.setDistance(newDistance);
                    v.setPreviousVertex(edge.getStart());
                }
            }
        }

        for (com.softwarescares.Edge edge : edgeList)
        {
            if (edge.getTarget().getDistance() != Double.MAX_VALUE)
            {
                if (hasCycle(edge))
                {
                    System.out.println("There has been a negative cycle detected...");
                    return;
                }
            }
        }


    }

    private boolean hasCycle(com.softwarescares.Edge edge)
    {
        return edge.getStart().getDistance() +  edge.getWeight() < edge.getTarget().getDistance();
    }

    public void shortestPathTo(com.softwarescares.Vertex target)
    {
        if (target.getDistance() == Double.MAX_VALUE) System.out.println("There is No Path");
        com.softwarescares.Vertex actualVertex = target;
        while (actualVertex.getPreviousVertex() != null)
        {
            System.out.println(actualVertex.getName() + " ");
            actualVertex = actualVertex.getPreviousVertex();
        }
    }

}
