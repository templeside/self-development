class Solution {
    /**
    hashMap과 dfs를 통해서 이 난관을 극복한다.
    O(V+E) where V is vertex, E is edge.
    
    아니 그렇다면 어떻게 이 edges들이 다 이어졌는지 생각을 해 낼 수 있을까????
    because it is undirected graph.
    visited.io 뜻을 몰르는데 알아내면 대단한 거지..
    
    parent와 parent가 아닌 node들을 알아내야 하고,
    parent node가 아닌 다른 node들을 방문할 때, visited하면 cycle이 생기고, 그렇게 된다면 끝끝.
    
    어떻게 해야하나???
    first, make the adjacencyList.
    
    cycle을 체크하는 경우 - 다시 그 adjacency가 visited 했다는 것을 확인하면 된다.
    다만 parent는 빼고.
    parent는 다시 visit 할 수 있기 때문에.
    
    그렇다면 parent node를 설정해야 하겠네
    
    어떻게 설정을 할까?
     hashmap을 통해 만들어 내야하는 존재들이 있따.
     undirected map, which means I am able to find the adjacentLists my self.
     if visited and it is not parent, then return false.
     
     and also, the visited thing, return true when dfs is true and the visited nodes are the same length!
         
    
    **/

    HashMap<Integer, List<Integer>> adjacencyList;
    HashSet<Integer> visited;
    
    public boolean validTree(int n, int[][] edges) {
        if(edges.length !=n-1)return false;
        // <parent, child>
        // HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        // HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        
        for(int i=0; i<n; i++){
            adjacencyList.put(i, new ArrayList<>());
        }
        
        for(int[] edge: edges){
            // if(!adjacencyList.containsKey(edge[0]))
            //     adjacencyList.put(edge[0], new ArrayList<>());
            // if(!adjacencyList.containsKey(edge[1]))
            //     adjacencyList.put(edge[1], new ArrayList<>());
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }
        
        
        
        // 아니 첫번째 parent는 어떻게 찾지????? 음 어떻게 찾을까??????그냥 manually 넣는 것일까????
        // 그냥 manually 넣는 것이다..!
        
        return dfs(0, -1 , visited, adjacencyList) && visited.size() == n;
    }
    
    public boolean dfs(int node,int parent, HashSet<Integer> visited, HashMap<Integer, List<Integer>> adjacencyList){
        if(visited.contains(node))return false;
        visited.add(node);
        for(int neighbor: adjacencyList.get(node)){
            if(parent !=neighbor){
                boolean result = dfs(neighbor, node, visited, adjacencyList);
                if(!result) return false;
            }
        }
        return true;
    }
}