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
    int[] longest = new int[1];
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return longest[0]-1;
    }
    
    public int dfs(TreeNode root){
        if(root ==null)return 0;
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        longest[0] = Math.max(longest[0], 1+left+right);
        return Math.max(left, right)+1;
    }
}