package com.example.demo.model;

import java.util.*;

public class Dijkstra {
  public static HashMap<Character, Integer> algorithm(WeightedGraph graphInput, char StartingNode) {
    HashMap<Character, Integer> distances = new HashMap<>();
    HashMap<Character, List<Edge>> unvisited = graphInput.getMap();

    // all distances infinity
    for (Character node : unvisited.keySet()) {
      distances.put(node, Integer.MAX_VALUE);
    }

    distances.put(StartingNode, 0);


    while (!unvisited.isEmpty()) {
      Character currentNode = getMinDistanceNode(distances, unvisited);
      List<Edge> currentEdges = unvisited.get(currentNode);

      // update distances
      for (Edge edge : currentEdges) {
        int newDistance = distances.get(currentNode) + edge.getWeight();
        if (newDistance < distances.get(edge.getDestination())) {
          distances.put(edge.getDestination(), newDistance);
        }
      }

      unvisited.remove(currentNode);
    }

    return distances;
  }


  private static Character getMinDistanceNode(HashMap<Character, Integer> distances, HashMap<Character, List<Edge>> unvisited) {
    int minDistance = Integer.MAX_VALUE;
    Character minNode = null;
    for (Character node : distances.keySet()) {
      if (unvisited.containsKey(node) && distances.get(node) < minDistance) {
        minDistance = distances.get(node);
        minNode = node;
      }
    }
    return minNode;
  }
}
