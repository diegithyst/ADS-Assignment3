package com.example.demo;

import com.example.demo.model.Dijkstra;
import com.example.demo.model.WeightedGraph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

public class main {

    public static void main(String[] args) {

        WeightedGraph graph = new WeightedGraph();

        graph.addEdge('A', 'B', 2);
        graph.addEdge('A', 'C', 1);
        graph.addEdge('A', 'D', 7);
        graph.addEdge('A', 'E', 9);
        graph.addEdge('B', 'E', 1);
        graph.addEdge('C', 'F', 6);
        graph.addEdge('C', 'G', 12);
        graph.addEdge('E', 'D', 3);
        graph.addEdge('D', 'G', 2);
        graph.addEdge('E', 'G', 8);
        graph.addEdge('E', 'H', 7);
        graph.addEdge('F', 'G', 2);
        graph.addEdge('G', 'H', 1);

        //this is just tests if the program screams at you if the edge exists already
        //graph.addEdge('B', 'A', 2);
        //graph.addEdge('E', 'B', 1);

        //run the algorithm that takes this graph as a parameter here

        HashMap<Character, Integer> output = Dijkstra.algorithm(graph,
            'A');

        System.out.println(output.toString());
    }

}
