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
    private void createNodes(HashMap<Integer, List<Integer>> db,HashMap<Integer, Node> nodeIndex ){
        for(int n: db.keySet()){
            Node temp = new Node(n);
            nodeIndex.put(n, temp);
        }
    }
    
    private void findDB(Node node, HashMap<Integer, List<Integer>> db){
        if(db.containsKey(node.val))return;
        
        List<Integer> neighborList = new ArrayList<>();
        for(Node n: node.neighbors){
            neighborList.add(n.val);
        }
            
        db.put(node.val, neighborList);
        
        for(Node n: node.neighbors){
            findDB(n, db);
        }
    }
    
    public Node cloneGraph(Node node) {
        if(node ==null)return null; //base case
        
        // <itself, neighborList>
        HashMap<Integer, List<Integer>> db = new HashMap<>();
        // <itself number, refernce>
        HashMap<Integer, Node> nodeIndex = new HashMap<>();
        
        findDB(node, db);
        createNodes(db, nodeIndex);
        
        for(int k: db.keySet()){
            Node newNode = nodeIndex.get(k);
            
            for(int neighborKey: db.get(k)){
                newNode.neighbors.add(nodeIndex.get(neighborKey));
            }
        }
        return nodeIndex.get(node.val);
    }

}