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
    /*
    updating the maxPath through global variable
        maxPath = Math.max(maxPath, root.left + root.right + root)
    return max path 
    */
    public int maxSum;
    public int maxPathSum(TreeNode root) {
        if(root ==null)
            return 0;
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        maxSum = Math.max(maxSum, left+right+root.val);
        
        return Math.max(Math.max(left,right)+root.val, 0);
    }
}