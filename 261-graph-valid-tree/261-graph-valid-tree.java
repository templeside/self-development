class Solution {
    /**
    그래프에서 tree로 될려면 어떠한 특성이 있어야 하는가를 물어보고싶은 것이다.
    
    picking from the vertex, find the visited node.
    if it is not a parent node, then the node itself is visited, then it is false. 
    graph -> tree.
    graph - tree is almost same. 
    
    picking on vertex, and that point is going to be a tree of the structure.
    
    set the parent hashmap.
    if adjacencies except the hashmap is visited, then the graph is not valid, and returning that is false.
    
    1. first of all, those are edges and consist of int array, we will transform this structure to HashMap structure for easier usage.
    
    **/
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjacencyList= new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        

        for(int i=0; i< n; i++)
            adjacencyList.put(i, new ArrayList<>());
        for(int[] edge: edges){
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        return dfs(0, -1, adjacencyList, visited) && visited.size() ==n;
    }
    
    public boolean dfs(int currNode, int parent, HashMap<Integer,List<Integer>> adjacencyList, HashSet<Integer> visited){
        //base case?? no필요.
        if(visited.contains(currNode))return false;
        
        visited.add(currNode);
        
        for(int adjacentNode: adjacencyList.get(currNode)){
            if(adjacentNode != parent){

                boolean result = dfs(adjacentNode, currNode, adjacencyList, visited);
                
                if(!result)
                    return false;
            }
        }
            
        // return case??   
        
        return true;
    }
}