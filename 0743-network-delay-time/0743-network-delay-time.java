class Solution {
    /*
    generate graph<source, target, weight>
    generate heap<weight, target>
    generate visited
    
    add heap(0, k)
    while(!heap.isEmpty()){
        if visited:
            continue
        add visited
        for(adjacnecies):
            add adjacencies to heap
    }
    
    return visited == n? return total delay time: -1
    
    
    */
    public int networkDelayTime(int[][] times, int n, int k) {
//         generate graph<source, target, weight>
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        for(int[] time: times){
            int source = time[0];   //source -> target
            int target = time[1];
            int weight = time[2];
            Map<Integer,Integer> adjList = map.getOrDefault(source, new HashMap<>());
            adjList.put(target, weight);
            map.put(source, adjList);
        }
        
//         generate heap<<target, weight>
        Queue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
//         generate visited
        Set<Integer> visited = new HashSet<>();

        pq.add(new int[]{k,0});
        int returnVal = 0;
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currWeight = curr[1];
//             if visited:
//                 continue
            if(visited.contains(currNode))
                continue;
//             add visited
            visited.add(currNode);
//             for(adjacnecies):
            returnVal = currWeight;

            if(map.containsKey(currNode)){
                for(Map.Entry<Integer, Integer> adj: map.get(currNode).entrySet()){
                    int newNode = adj.getKey();
                    int newWeight = currWeight +adj.getValue();
    //                 add adjacencies to heap
                    pq.add(new int[]{newNode, newWeight});
                }
            }
        }

        return visited.size() == n? returnVal: -1;
    }
}