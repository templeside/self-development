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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int currPath){
        if(root == null) return 0;
        
        currPath = currPath*10+ root.val;
        if(root.left == null && root.right ==null)
            return currPath;
        
        int left= dfs(root.left, currPath);
        int right =dfs(root.right, currPath);
        
        return left+right;
    }
}