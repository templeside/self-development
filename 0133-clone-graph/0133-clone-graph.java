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
    check is this already have been or not.
    
    do recursion:
        create newNode
        add to map
        for neighbor: node.neighbors:
            newNode.neighbors.add(recursion(neighbor))
        return newNode
        
    also for datastructure:
        Map<node, newNode>

    */
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();

        return recursion(node, map);
    }
    public Node recursion(Node oldNode, Map<Node, Node> map){
        if(oldNode == null){
            return null;
        }
        
        if(map.containsKey(oldNode)){
            return map.get(oldNode);
        }

        Node newNode = new Node(oldNode.val);
        map.put(oldNode, newNode);

        for(Node oldNeighbor: oldNode.neighbors){
            newNode.neighbors.add(recursion(oldNeighbor, map));
        }        
        return newNode;
    }
}