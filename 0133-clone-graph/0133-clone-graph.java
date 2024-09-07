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
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        HashMap<Node, Node> oldNew = new HashMap<>();
        
        return recursion(node, oldNew);
    }
    public Node recursion(Node oldCurr, HashMap<Node,Node> oldNew){
        if(oldNew.containsKey(oldCurr))
            return oldNew.get(oldCurr);
        
        Node newCurr = new Node(oldCurr.val);
        oldNew.put(oldCurr, newCurr);
        for(Node oldNeighbor: oldCurr.neighbors){
            newCurr.neighbors.add(recursion(oldNeighbor, oldNew));
        }
        return newCurr;
    }
}