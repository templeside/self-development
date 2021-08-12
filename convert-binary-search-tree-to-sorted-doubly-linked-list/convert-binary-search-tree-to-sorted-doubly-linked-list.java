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
    Node first = null;
    Node last = null;
    public Node treeToDoublyList(Node root) {
        if(root ==null) return null;
        
        helper(root);
        
        last.right = first;
        first.left = last;
        return first;
    }
    public void helper(Node root){
        if(root ==null) return;
        int val = root.val;
        helper(root.left);
        
        if(first != null){   // to find the head.
            last.right = root;    
            root.left = last;     
        }
        else{
            first = root;

                    
        }
        last = root;

        
        if(root.right !=null)
            helper(root.right);
    }
    
}