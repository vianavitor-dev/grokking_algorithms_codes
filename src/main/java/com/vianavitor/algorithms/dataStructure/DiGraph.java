package com.vianavitor.algorithms.dataStructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// implements a Directed Graph(digraph)
public class DiGraph <ID, T> {
    private Map<VertexExample<ID,T>, List<VertexExample<ID,T>>> graph = new HashMap<>();

    public void addVertex(VertexExample<ID,T> vertex) {
        graph.put(vertex, List.of());    
    }

    public void addEdge(VertexExample<ID,T> vertex, List<VertexExample<ID,T>> vertexes) {
        graph.put(vertex, vertexes);
    }

    public List<VertexExample<ID,T>> getNeighborns(VertexExample<ID,T> vertex) {
        return graph.get(vertex);
    }

    public void display() {
        for (Entry<VertexExample<ID,T>, List<VertexExample<ID,T>>> entry : graph.entrySet()) {
            if (entry.getValue().isEmpty()) {
                continue;
            }
            
            for (VertexExample<ID,T> value : entry.getValue()) {
                System.out.println("- " + value.id());
            }
        }
    }
    
}

