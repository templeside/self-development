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
    int count;
    public int countNodes(TreeNode root) {
        count =0;
        
        helper(root);
        return count;
    }
    
    private boolean helper(TreeNode root){
        // if(root == null || (root.left ==null && root.right ==null)){
        if(root == null)            //edge case 
            return true;

        if(root.left == null && root.right ==null){     // success
            count++;
            return true;        
        }
        
        if(root.left ==null && root.right!=null)
            return false;
        
        boolean left = helper(root.left);
        boolean right= helper(root.right);
        
        if(left && right){
            count ++;
            return true;
        }
        else return false;
    }
}