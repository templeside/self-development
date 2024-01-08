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
    2-4
    1-3
    dfs
    HashMap<prevNode, newNode>
        if not found:
            dfs
        if found:
            add to adjacencies
    */
    public Node cloneGraph(Node node) {
        Map<Node, Node> newNodes = new HashMap<>();
        return createNodes(node, newNodes);
    }
    public Node createNodes(Node node, Map<Node, Node> newNodes){
        if(node ==null)return null;
        Node newNode = newNodes.containsKey(node)? newNodes.get(node) : new Node(node.val);
        newNodes.put(node, newNode);
        
        for(Node neighbor: node.neighbors){
            if(!newNodes.containsKey(neighbor))
                createNodes(neighbor, newNodes);
            
            Node newNeighborNode = newNodes.get(neighbor);
            newNode.neighbors.add(newNeighborNode);
        }
        return newNode;
    }
}