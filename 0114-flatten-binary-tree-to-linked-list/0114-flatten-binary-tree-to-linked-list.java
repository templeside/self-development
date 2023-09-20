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
/*
i can do if i have global variable.
        1
     /    \
    2      5
   / \      \
  3   4      6
  
  how to make it in space in O(1)?
  that means should be in place swap.
  
  I think I can do preorder.
  templeft = root.left
  tempright = root.right
  left = null
  right = templeft
  
  go to right leaf, leaf.right = tempright
  return root
  
*/
class Solution {
    public void flatten(TreeNode root) {
                
        recursion(root);
    }
    public TreeNode recursion(TreeNode root){
        if(root == null)
            return null;
        
        if(root.left ==null && root.right ==null)   // leaf node. done.!!
            return root;
        
        TreeNode leftTail = recursion(root.left);
        TreeNode rightTail = recursion(root.right);
        
        if(leftTail !=null){
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightTail == null? leftTail: rightTail;
    }
}