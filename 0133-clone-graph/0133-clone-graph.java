/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    /*
    iterate DFS with oldNode
    hashMap<oldNode, newNode>
    visited<oldNode>
    
    dfs(){
        visited.put(oldNode)
        for(oldNeighbors: neighbors)
            if(not in hashmap)
                if(not visited)
                dfs(oldNeighbors)
                
    }
    
    return newNode
    */
    public Node cloneGraph(Node node) {
        if(node ==null)return null;
        HashMap<Node, Node> map = new HashMap<>();
        
        return dfs(node, map);
    }

    public Node dfs(Node oldNode, HashMap<Node,Node> map){
        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);
        
        for(Node oldNeighbor: oldNode.neighbors){
            if(!map.containsKey(oldNeighbor)){
                dfs(oldNeighbor, map);
            }
            
            newNode.neighbors.add(map.get(oldNeighbor));
        }
        return newNode;
    }
}