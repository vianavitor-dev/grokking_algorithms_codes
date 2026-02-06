package com.vianavitor.algorithms.search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class DijkstraAlgorithm {
    private final Set<String> visited = new HashSet<>();

    private String getNodeWithMinCost(HashMap<String, Integer> costs) {
        int minCost = Integer.MAX_VALUE;
        String node = null;

        for (Entry<String, Integer> current : costs.entrySet()) {
            if (current.getValue() < minCost && !visited.contains(current.getKey())) {
                minCost = current.getValue();
                node = current.getKey();

                visited.add(current.getKey());
            }
        }

        return node;
    }

    public void search(HashMap<String, HashMap<String, Integer>> graph, HashMap<String, Integer> costs, HashMap<String, String> parents) {
        String node = getNodeWithMinCost(costs);

        while (!node.isEmpty() || node != null) {
            visited.add(node);
            System.out.println(node);

            int cost = costs.get(node);

            if (graph.get(node) == null) {
                break;
            }

            Set<Entry<String, Integer>> neighbors = graph.get(node).entrySet();

            for (Entry<String, Integer> neighbor : neighbors) {
                String n = neighbor.getKey();
        
                int neighborCost = neighbor.getValue();
                int costNodeToNeighbor = cost + neighborCost;

                int currentNeighborCost = costs.get(n);

                if (costNodeToNeighbor < currentNeighborCost) {
                    costs.put(n, costNodeToNeighbor);
                    parents.put(n, node);
                }
            }

            node = getNodeWithMinCost(costs);
        }
    }

    public String showTheMinPath(HashMap<String, String> parents, String last) {
        if (parents.get(last) == null) {
            return parents.get(last);
        }

        return showTheMinPath(parents, parents.get(last)) + " => " + parents.get(last);
    }
}
