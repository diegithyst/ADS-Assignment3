package com.example.demo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeightedGraph {
    private HashMap<Character, List<Edge>> adjencyMap;

    public WeightedGraph(){
        adjencyMap = new HashMap<>();
    }

    public void addNode(char node){
        adjencyMap.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(char source, char destination, int weight){
        if(!adjencyMap.containsKey(source)){
            addNode(source);
        }
        if(!adjencyMap.containsKey(destination)){
            addNode(destination);
        }
        if(!edgeExists(source, destination) && !edgeExists(destination, source)) {
            adjencyMap.get(source).add(new Edge(destination, weight));
        }else {
            System.out.println("Edge exists!!");
        }
    }


    public boolean edgeExists(char source, char destinaion){
        if(adjencyMap.get(source) != null){
            for(Edge edge : adjencyMap.get(source)){
                if(edge.destination == destinaion){
                    return true;
                }
            }
        }
        return false;
    }
    public List<Edge> getNodes(char source){
        return adjencyMap.getOrDefault(source, new ArrayList<>());
    }

}


