import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        // Build the adjacency list
        List<Set<Integer>> adj = new ArrayList<>(n);
        for(int i=0; i<n; i++) {
            adj.add(new HashSet<>());
        }

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // Initialize first layer of leaves
        List<Integer> leaves = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(adj.get(i).size() == 1){
                leaves.add(i);
            }
        }

        int remainingNodes = n;
        while(remainingNodes > 2){
            remainingNodes -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            // Remove current leaves along with the edges
            for(int leaf : leaves){
                // Each leaf has only one neighbor
                int neighbor = adj.get(leaf).iterator().next();
                adj.get(neighbor).remove(leaf);
                if(adj.get(neighbor).size() == 1){
                    newLeaves.add(neighbor);
                }
            }

            // Prepare for next round
            leaves = newLeaves;
        }

        // The remaining nodes are the roots of MHTs
        res.addAll(leaves);
        return res;
    }
}
