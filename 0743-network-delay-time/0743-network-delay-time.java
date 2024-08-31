class Solution {
    /*
    times - u(source), v(target), w(weight)
    N - number of Nodes
    K- start Node
    
    if not possible, return -1
    return min time to visit all Nodes
    
    main structures:
        graph - HashMap<source, Map<target, weight>>
        heap - PriorityQueue<weight, targetNode>
        visited - HashSet<Node>
    */
    public int networkDelayTime(int[][] times, int N, int K) {
        //  <source, Map<target, weight>>  source -> target
        Map<Integer, Map<Integer,Integer>> adjMap = new HashMap<>();
        for(int[] time : times){    //times - u(source), v(target), w(weight)
            adjMap.putIfAbsent(time[0], new HashMap<>());
            adjMap.get(time[0]).put(time[1], time[2]);
        }
        
        //<weight, targetNode>
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        
        pq.add(new int[]{0, K});
        
        Set<Integer> visited = new HashSet<>();
        int res = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int currNode = cur[1];
            int currDelayTime = cur[0];
            
            if(visited.contains(currNode))
                continue;
            visited.add(currNode);

            res = currDelayTime;
            if(adjMap.containsKey(currNode)){
                for(int next : adjMap.get(currNode).keySet()){
                    int nextWeight = currDelayTime + adjMap.get(currNode).get(next);
                    pq.add(new int[]{nextWeight, next});
                }
            }
        }
        return visited.size() == N ? res : -1;
    }
}
