class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length !=n-1)return false;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        for(int i=0; i<n; i++)
            graph.put(i, new ArrayList<>());
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int currVertex=0;
        int parentVertex = -1;
        boolean isValid = checkValid(currVertex, parentVertex, visited, graph);
        if(!isValid)return false;
        
        return visited.size() == n;
    }
    
    /*
    dfs:
        add to visited
        for( neighbor: neighbors)
            if(parent)
                skip
            check visited or not
            if visited
                return false
            else dfs
        
        return visited or not
    */
    public boolean checkValid(int currVertex, int parentVertex, Set<Integer> visited, Map<Integer, List<Integer>> graph){
        visited.add(currVertex);
        
        for(int neighbor: graph.get(currVertex)){
            if(neighbor == parentVertex)continue;
            if(visited.contains(neighbor))return false;
            
            checkValid(neighbor, currVertex, visited, graph);
        }
        return true;
    }
}