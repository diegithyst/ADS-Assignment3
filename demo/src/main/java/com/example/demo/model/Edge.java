package com.example.demo.model;

public class Edge {
    char destination;
    int weight;

    public Edge(char destination, int weight){
        this.destination = destination;
        this.weight = weight;
    }

    public Integer getWeight()
    {
        return weight;
    }

    public Character getDestination()
    {
        return destination;
    }
}
