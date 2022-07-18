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
    public static Integer max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        
        backtrack(root);
        return max;
    }
    
    public int backtrack(TreeNode root){
        if(root ==null)return 0;
        
        int left = Math.max(backtrack(root.left),0);
        int right = Math.max(backtrack(root.right),0);
        
        int totalSum = left+right+ root.val;
        max = Math.max(max, totalSum);
        
        return Math.max(left,right)+root.val;
    }
}