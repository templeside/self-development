class Solution {
    /**
    building graph and iterate through dfs. then, check the visited set for counting the connected components.
    the number of dfs call is the counting of the components.
    
    1. implement adjacencyList
    2. build the graph
    3. for iteration, 
        1. if visited, skip.
        2. count++;
        3. look out all of the adjacencies, mark visited.
    
    Time complexity: O(V+E) V is vertex, E is edge.
    we iterate all vertices when do the dfs
    we iterate all edges when we implement a graph.
    **/
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i=0; i < n; i++){
            adjacencyList.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        for(int i=0; i< n; i++){
            if(!visited.contains(i)){
                count++;
                dfs(i, adjacencyList, visited);
            }
        }
        return count;
    }
    
    public void dfs(int currNode, HashMap<Integer, List<Integer>> adjacencyList, HashSet<Integer> visited ){
        if(visited.contains(currNode))return;
        
        visited.add(currNode);
        for(int neighbor: adjacencyList.get(currNode)){
            dfs(neighbor, adjacencyList, visited);
        }
    }
}