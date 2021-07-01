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
    public boolean isValidBST(TreeNode root) {
        if(root ==null) return true;
        if(root.left == null && root.right ==null) return true;
        
        boolean checkLeft = true;
        boolean checkRight = true;
        if(root.left !=null){
            TreeNode leftNode = mostRight(root.left);
            checkLeft = leftNode.val < root.val;
        }
        if(root.right !=null){
            TreeNode rightNode = mostLeft(root.right);
            checkRight = rightNode.val> root.val;
        }        
        
        return checkLeft && checkRight && isValidBST(root.left) && isValidBST(root.right);
    }
    
    private TreeNode mostRight(TreeNode root){
        if(root.right == null)return root;
        return mostRight(root.right);
    }
    
    private TreeNode mostLeft(TreeNode root){
        if(root.left == null)return root;
        return mostLeft(root.left);
    }
}