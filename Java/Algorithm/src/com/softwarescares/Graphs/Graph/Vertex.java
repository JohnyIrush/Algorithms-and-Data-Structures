package com.softwarescares;

import java.util.ArrayList;
import java.util.List;

public class Vertex
{
    private String name;
    private boolean visited;
    private  double distance = Double.MAX_VALUE;
    private Vertex previousVertex;


    private List<Edge> adjacency_list;

    Vertex(String name)
    {
        this.name = name;
        this.adjacency_list = new ArrayList<>();
    }

    public void addNeighbour(Edge edge)
    {
        this.adjacency_list.add(edge);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isVisited()
    {
        return visited;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public List<Edge> getAdjacency_list()
    {
        return adjacency_list;
    }

    public void setAdjacency_list(List<Edge> adjacency_list)
    {
        this.adjacency_list = adjacency_list;
    }
    public Vertex getPreviousVertex() {
        return previousVertex;
    }

    public void setPreviousVertex(Vertex previousVertex) {
        this.previousVertex = previousVertex;
    }
}
