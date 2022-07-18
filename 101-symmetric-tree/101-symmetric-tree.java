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
    comparing by iteration. 
    how???? 
    keep track of left and right.....
    
**/
    public boolean isSymmetric(TreeNode root) {
        return isValid (root, root);
    }
    public boolean isValid(TreeNode left, TreeNode right){
        if(left == null && right ==null)return true;
        if(left == null || right == null)return false;
        
        return left.val == right.val && isValid(left.left, right.right) && isValid(left.right, right.left);
    }
}