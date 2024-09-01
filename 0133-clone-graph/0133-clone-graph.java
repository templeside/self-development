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
/*
int val
List<Node> neighbors

hashmap <prevnode, newNode>
do dfs()
    base case - leafnode & visited
    if(visited):
        return hashmap.get(node)
    for neighbors:
        newAdjNode = add(dfs(neighbors))
        newNode.add(newAdjNode);
    return newNode
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node ==null)return null;
        
        Map<Node, Node> hashMap =new HashMap<>();
        Set<Node> visited = new HashSet<>();// Set<oldNodes>
        return dfs(node, hashMap, visited);
    }
    public Node dfs(Node oldNode, Map<Node, Node> hashMap, Set<Node> visited){
        if(visited.contains(oldNode))
            return hashMap.get(oldNode);
        
        Node newNode = new Node(oldNode.val);
        visited.add(oldNode);
        hashMap.put(oldNode, newNode);
        
        for(Node oldAdjNode : oldNode.neighbors){
            Node newAdjNode = dfs(oldAdjNode, hashMap, visited);
            newNode.neighbors.add(newAdjNode);
        }
        return newNode;
    }
}