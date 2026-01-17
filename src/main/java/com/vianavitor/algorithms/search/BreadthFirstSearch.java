package com.vianavitor.algorithms.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import com.vianavitor.algorithms.dataStructure.DiGraph;
import com.vianavitor.algorithms.dataStructure.VertexExample;

public class BreadthFirstSearch <ID, T> {
    // contains the vertexes to be analysed, ordered by the degree
    private final Queue<VertexExample<ID, T>> vertexes = new LinkedList<>();
    // stores the vertexes analysed to avoid reanalyse them
    private final Set<VertexExample<ID, T>> analysed = new HashSet<>();

    public BreadthFirstSearch(List<VertexExample<ID, T>> start) {
        vertexes.addAll(start);
    }

    // this function implements the BFS (Breath-First Search)
    // it returns true if any vertex value matches the value passed, and false else
    public boolean search(DiGraph<ID, T> graph, T value) {
        while (!vertexes.isEmpty()) {
            VertexExample<ID, T> vertex = vertexes.remove();
     
            if (analysed.contains(vertex)) {
                continue;
            }

            System.out.println("vertex: " + vertex.id());

            if (vertex.value().equals(value)) {
                System.out.println("=> FOUND");
                return true;
            }

            // if the value the current vertex and value passed doesn't match, 
            // then get the edges of the current vertex and add them to vertexes to be analysed
            List<VertexExample<ID, T>> neighborns = graph.getNeighborns(vertex);
            if (!neighborns.isEmpty()) {
                vertexes.addAll(neighborns);
            }

            analysed.add(vertex);
        }

        return false;
    }
}
