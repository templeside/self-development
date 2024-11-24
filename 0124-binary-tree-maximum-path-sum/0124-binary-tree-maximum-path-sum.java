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
    from this experience, i can have 
    1,2,3
    get th max path global variable to iterate over
    
    have recursion:
        recursion, could have the edges
        left = recursion(root.left)
        right = recursion(root.right)
        currPathSum = left+ right + root.val
        return Math.max(left,right)+root.val
        
        [1,-2,3]
        1
    
    */
    public int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        helper(root);
        return maxSum;
    }
    public int helper(TreeNode root){
        if(root ==null){
            return 0;
        }
    //     recursion, could have the edges
    //     left = recursion(root.left)
        int left = Math.max(helper(root.left),0);
    //     right = recursion(root.right)
        int right = Math.max(helper(root.right),0);
    //     currPathSum = left+ right + root.val
        int currPathSum = left+right+root.val;
        maxSum = Math.max(maxSum, currPathSum);
        return Math.max(left,right)+root.val;
    }
}