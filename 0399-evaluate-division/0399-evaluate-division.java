import java.util.*;

class Solution {
    // Nested class to represent a node and the corresponding edge weight
    private static class Node {
        String name;
        double value;

        Node(String name, double value) {
            this.name = name;
            this.value = value;
        }
    }

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {
        
        // Build the adjacency list for the graph
        Map<String, List<Node>> adj = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            double quotient = values[i];
            
            // Add edge dividend -> divisor
            adj.computeIfAbsent(dividend, k -> new ArrayList<>())
               .add(new Node(divisor, quotient));
            
            // Add edge divisor -> dividend
            adj.computeIfAbsent(divisor, k -> new ArrayList<>())
               .add(new Node(dividend, 1.0 / quotient));
        }

        // Prepare the result array
        double[] results = new double[queries.size()];
        
        // Process each query using BFS
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String src = query.get(0);
            String target = query.get(1);
            results[i] = bfs(src, target, adj);
        }
        
        return results;
    }

    private double bfs(String src, String target, Map<String, List<Node>> adj) {
        // If either the source or target is not present in the graph
        if (!adj.containsKey(src) || !adj.containsKey(target)) {
            return -1.0;
        }
        
        // Initialize BFS
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        // Start from the source with an initial product of 1.0
        queue.offer(new Node(src, 1.0));
        visited.add(src);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            String currentNode = current.name;
            double currentProduct = current.value;
            
            // If the target is found, return the accumulated product
            if (currentNode.equals(target)) {
                return currentProduct;
            }
            
            // Traverse the neighbors
            for (Node neighbor : adj.get(currentNode)) {
                if (!visited.contains(neighbor.name)) {
                    visited.add(neighbor.name);
                    queue.offer(new Node(neighbor.name, currentProduct * neighbor.value));
                }
            }
        }
        
        // If the target is not reachable from the source
        return -1.0;
    }
}
