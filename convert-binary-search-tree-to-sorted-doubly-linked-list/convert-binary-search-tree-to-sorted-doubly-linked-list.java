/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    // the smallest (first) and the largest (last) nodes
    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root){
        if(root == null) return null;
        helper(root);
        last. right = first;
        first.left = last;
        return first;
    }
    
    private void helper(Node node){
        if(node == null) return;
        // left
        helper(node.left);
        
        if(last !=null){
            last.right = node;      // link with the previous node with current node
            node.left = last;      
        }else{
            first = node;           // if this is the first node of the dfs
        }
        last = node;
        
        //right
        helper(node.right);
        
    }
}