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
    in order traversal, compare with prev value.
    **/
    TreeNode prev;
    boolean valid;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        valid = true;
        inorder(root);
        return valid;
    }
    
    public void inorder(TreeNode root){
        if(root == null || !valid)return ;
        
        inorder(root.left);
        
        if(prev ==null|| prev.val< root.val){
            prev= root;
        }else{
            valid = false;
        }
        
        inorder(root.right);
    }
}