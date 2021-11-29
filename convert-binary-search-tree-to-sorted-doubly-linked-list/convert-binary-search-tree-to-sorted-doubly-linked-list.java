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
    Node head;
    Node tail;
    public Node treeToDoublyList(Node root) {
        if(root ==null) return null;
        head = null;
        tail = null;
        
        dfs(root);
        
        head.left = tail;
        tail.right = head;
        return head;
    }
    private void dfs(Node root){
        if( root ==null)return;
        
        dfs(root.left);
        
        if(head ==null){
            head = root;
        }else{
            root.left = tail;
            tail.right = root;    
        }
        
        tail = root;
        
        dfs(root.right);
    }
}