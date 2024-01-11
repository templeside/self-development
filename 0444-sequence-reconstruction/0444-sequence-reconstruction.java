class Solution {
    public boolean sequenceReconstruction(int[] nums, List<List<Integer>> sequences) {
        int n = nums.length;

        int[] inDegree = new int[n + 1];    // #incoming nodes. a->b -{a:0, b:1}
        
        //create graph
        List<List<Integer>> graph = new ArrayList<>();
        for(int listSize = 0; listSize <= n; listSize++) {
            graph.add(new ArrayList<>());
        }

        for(List<Integer> seq : sequences) {
            for(int index = 1; index < seq.size(); index++) {
                int nodeA = seq.get(index - 1);
                int nodeB = seq.get(index);
                
                // if(nodeA < 1 || nodeA > n || nodeB < 1 || nodeB > n) return false;
                
                graph.get(nodeA).add(nodeB);
                inDegree[nodeB]++;
            }
        }

        Queue<Integer> topSort = new LinkedList<>();
        for(int node = 1; node <= n; node++) {
            if(inDegree[node] == 0) {
                topSort.offer(node);
            }
        }

        for(int index = 0; index < n; index++) {
            if(topSort.size() > 1 || nums[index] != topSort.peek()) return false;

            int curr = topSort.poll();
            for(int next : graph.get(curr)) {
                inDegree[next]--;
                if(inDegree[next] == 0) topSort.offer(next);
            }
        }

        return true;
    }
}
