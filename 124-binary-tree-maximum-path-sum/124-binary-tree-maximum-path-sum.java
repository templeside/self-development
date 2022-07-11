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
/**
dfs(root)
reutrns max sum path left or right.

1.iterate through each path
2. find the left and right path.
3. left+right+ curr.val -> compare with maxSum and switch to the maxSum.
4. return the max path length including curr.val
**/
class Solution {
    public int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode root){
        if(root ==null)return 0;
        
        int left= Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);
        
        int currSum = left+right+ root.val;
        max = Math.max(max, currSum);
        
        return Math.max(left, right)+root.val;
    }
}