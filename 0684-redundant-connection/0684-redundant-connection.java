class Solution {
    // for each edge(u,v), traverse the graph with a depth-first search to see if we can connect u to v.
    // seen으로 visited 했는지 안했는지 확인.
    
    
    //Since the question require us to remove the redundant edge, when we constructing the graph, we do dfs on each edge to see is it redundant, if yes return the edge, if no add the edge into the graph.

// Why dfs can find redundant. Actually a redundant edge means after we add this edge, the graph will contain a cycle. So, when we came across a new edge, we do dfs from its start and its end, if there already exist a path from start to end, this new edge is redundant.

/*
    construct graph - because verticies are [1, n], we can easily generate it
        generate adjacency list
    for each edges:
        check is it preconstructed vertex or not
        if preconstructed vertex, 
            check visited or not.
        add current edge
    
    to check visited:
        iterate the adjacency list:
            if visited, return true;
            
*/    
    public int[] findRedundantConnection(int[][] edges) {
        // <Vertex, List<Edges>> - <U,V>
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        for(int i = 1; i <= edges.length; i++){
            hashMap.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            //when already having edges, check is this cycle. if cycle, return.
            if(!hashMap.get(edge[0]).isEmpty() && !hashMap.get(edge[1]).isEmpty()){
                //왜 visited가 edge마다 달라야 하는가???? 그 ndoe가 문제있는지 확인해야 되서..?   
                boolean[] visited = new boolean[edges.length + 1]; 
                if(isCycle(edge[0], edge[1], hashMap, visited))
                    return edge;
            }
            
            //add new edges to vertex
            hashMap.get(edge[0]).add(edge[1]);
            hashMap.get(edge[1]).add(edge[0]);
        }
        
        //if not found
        return new int[2];
    }

    // checking has it used or not. only for checking purpose.
    public boolean isCycle(int src, int target, HashMap<Integer, List<Integer>> hashMap, boolean[] visited){
        if(src == target){
            return true;
        }
        visited[src] = true;
        List<Integer> adjList = hashMap.get(src);

        //get adjacency list
        //if already found adjacency list, that means cycle
        for(int next: adjList){
            if(!visited[next]){
                if(isCycle(next, target, hashMap, visited)){
                    return true;
                }
                visited[src] = true;
            }
        }
        return false;
    }
}