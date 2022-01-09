package com.softwarescares;

public class Edge
{
    private double weight;
    private Vertex start;
    private Vertex target;

    public Edge(double weight, Vertex start, Vertex target)
    {
        this.weight = weight;
        this.start = start;
        this.target = target;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public Vertex getStart()
    {
        return start;
    }

    public void setStart(Vertex start)
    {
        this.start = start;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target)
    {
        this.target = target;
    }
}
