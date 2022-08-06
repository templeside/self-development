class Solution {
/**
first intuition, I can have the meaning of the typical things. 그게 무엇이냐하면 in every nodes, the graph should be a valid tree - that means there should not be any cycle. soit should have only one parent, and other is children.

so, it only should iterate except parent node. 

having the parent node, just having the focusness, I would just have the DFS iteration for checking is there a duplication and making a cycle.

so, sudo will going to be:
0. implement an adjacency - because it is graph.
1. draw the graph
2. from the node 0, search for the DFS(currNode, parent, hashSet<Integer> visited)
    a. add to visited
    b. iterate the adjacencies
        if parent - skip
        if not parent - but visited - return false;
3. return visited.size() == n
**/
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjacencies = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i=0; i< n; i++){
            adjacencies.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            adjacencies.get(edge[0]).add(edge[1]);
            adjacencies.get(edge[1]).add(edge[0]);
        }
        
        boolean result = dfs(0, -1, visited, adjacencies);
        System.out.println(visited.size());
        if(result== false)return false;
        
        return visited.size() == n;
    }
    /**
    0-[1,2,3]
    1-[0,4]
    2-[0]
    3-[0]
    4-[1]
    visited -[0,1]
    
    dfs(0,-1, visited, adjacencies)
        dfs(1,0, visited, adjacencies)
        dfs(2,0, visited, adjacencies)
        dfs(3,0, visited, adjacencies)
    **/
    public boolean dfs(int currNode, int parent, HashSet<Integer> visited, HashMap<Integer, List<Integer>> adjacencies){
        // if(visited.contains(currNode))return false;
        visited.add(currNode);
        for(int neighbor: adjacencies.get(currNode)){
            if(neighbor == parent)continue;
            else if(visited.contains(neighbor))return false;
            
            visited.add(neighbor);
            boolean result =  dfs(neighbor, currNode, visited, adjacencies);
            if(!result)return false;
        }
        return true;
    }
}