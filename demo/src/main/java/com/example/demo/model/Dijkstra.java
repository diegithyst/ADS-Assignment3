package com.example.demo.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dijkstra {

  public static HashMap<Character, Integer> algorithm(WeightedGraph graphInput, char startingNode) {
    HashMap<Character, Integer> distances = new HashMap<>();
    HashMap<Character, List<Edge>> unvisited = new HashMap<>(graphInput.getMap());

    // Initialize distances to infinity
    for (Character node : unvisited.keySet()) {
      distances.put(node, Integer.MAX_VALUE);
    }
    distances.put(startingNode, 0);

    while (!unvisited.isEmpty()) {
      Character currentNode = getMinDistanceNode(distances, unvisited);
      if (currentNode == null) break; // No reachable nodes left

      int currentDistance = distances.get(currentNode);
      List<Edge> currentEdges = unvisited.get(currentNode);

      // Update distances
      for (Edge edge : currentEdges) {
        char destination = edge.getDestination();
        if (!unvisited.containsKey(destination)) continue; // Skip if destination is not in unvisited map

        int newDistance = currentDistance + edge.getWeight();
        if (newDistance < distances.get(destination)) {
          distances.put(destination, newDistance);
        }
      }

      unvisited.remove(currentNode);
    }

    return distances;
  }


  private static Character getMinDistanceNode(HashMap<Character, Integer> distances, HashMap<Character, List<Edge>> unvisited) {
    int minDistance = Integer.MAX_VALUE;
    Character minNode = null;
    for (Map.Entry<Character, Integer> entry : distances.entrySet()) {
      Character node = entry.getKey();
      int distance = entry.getValue();
      if (unvisited.containsKey(node) && distance < minDistance) {
        minDistance = distance;
        minNode = node;
      }
    }
    return minNode;
  }

}