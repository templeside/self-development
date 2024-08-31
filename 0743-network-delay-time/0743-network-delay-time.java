class Solution {
    /*
    times - u(source), v(target), w(weight)
    N - number of Nodes
    K- start Node
    
    if not possible, return -1
    return min time to visit all Nodes
    */
    public int networkDelayTime(int[][] times, int N, int K) {
        //  <source, <target, weight>>  source -> target
        Map<Integer, Map<Integer,Integer>> adjMap = new HashMap<>();
        for(int[] time : times){
            adjMap.putIfAbsent(time[0], new HashMap<>());
            adjMap.get(time[0]).put(time[1], time[2]);
        }
        
        //<weight, targetNode>
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        
        pq.add(new int[]{0, K});
        
        boolean[] visited = new boolean[N+1];
        int res = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int currDelayTime = cur[0];
            if(visited[curNode]) 
                continue;
            visited[curNode] = true;
            res = currDelayTime;
            N--;
            if(adjMap.containsKey(curNode)){
                for(int next : adjMap.get(curNode).keySet()){
                    int newDelayTime = currDelayTime + adjMap.get(curNode).get(next);
                    pq.add(new int[]{newDelayTime, next});
                }
            }
        }
        return N == 0 ? res : -1;
    }
}
