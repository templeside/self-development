class Solution {
    // for each edge(u,v), traverse the graph with a depth-first search to see if we can connect u to v.
    // seen으로 visited 했는지 안했는지 확인.
    
    
    //Since the question require us to remove the redundant edge, when we constructing the graph, we do dfs on each edge to see is it redundant, if yes return the edge, if no add the edge into the graph.

// Why dfs can find redundant. Actually a redundant edge means after we add this edge, the graph will contain a cycle. So, when we came across a new edge, we do dfs from its start and its end, if there already exist a path from start to end, this new edge is redundant.

/*
    construct graph - because verticies are [1, n], we can easily generate it
        generate adjacency list
    check visited or not.
    to check visited:
        
*/    
    boolean[] visited;

    public int[] findRedundantConnection(int[][] edges) {
        // <Vertex, List<Edges>> - <U,V>
        HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
        for(int i = 1; i <= edges.length; i++){
            hashMap.put(i, new ArrayList<>());
        }

        for(int[] edge: edges){
            visited = new boolean[edges.length + 1];
            
            //when already having edges, do dfs to find cycle
            if(!hashMap.get(edge[0]).isEmpty() && !hashMap.get(edge[1]).isEmpty() && dfs(edge[0], edge[1], hashMap)){
                return edge;
            }
            
            //add new edges to vertex
            hashMap.get(edge[0]).add(edge[1]);
            hashMap.get(edge[1]).add(edge[0]);
        }
        
        //if not found
        return new int[2];
    }

    // checking has it used or not
    public boolean dfs(int src, int target, HashMap<Integer, List<Integer>> hashMap){
        if(src == target){
            return true;
        }
        visited[src] = true;
        List<Integer> adjList = hashMap.get(src);

        //get adjacency list
        //if already found adjacency list, that means cycle
        for(int next: adjList){
            if(!visited[next]){
                if(dfs(next, target, hashMap)){
                    return true;
                }
            }
        }

        return false;
    }
}