/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
        1
    2       5
   3 4         6
   
   it should be in order and having the prev node. 
   starting from the right node.
   
   having the head, tail for the returnVal follow the preorder traversal.
   
   
  
    **/
    public TreeNode preHead;
    public TreeNode tail;
    
    public void flatten(TreeNode root) {
        preHead = new TreeNode(-1);
        tail = preHead;
        preOrder(root);

    }
    public void preOrder(TreeNode root){
        if(root ==null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        tail.right = root;
        tail.left = null;
        tail = tail.right;
        
        preOrder(left);
        preOrder(right);
    }
}