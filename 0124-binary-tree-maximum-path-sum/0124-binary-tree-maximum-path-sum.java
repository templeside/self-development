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
    [-10,9,20,null,null,15,7]
    -10
    /   \
    9   20
        /\
      15   7

updating the max and left, right child is different.
    */
    public int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        if(root ==null)return 0;
        
        recursion(root);
        return maxSum;
    }
    public int recursion(TreeNode root){
        //base case - if leaf
        if(root.left == null && root.right == null){
            maxSum = Math.max(maxSum, root.val);
            return root.val;
        }            
        
        //get left val, get right val
        int leftVal=0, rightVal=0;
        if(root.left !=null)
            leftVal = recursion(root.left);
        if(root.right !=null)
            rightVal = recursion(root.right);
        
        //updating the path sum
        int pathSum = root.val;
        if(leftVal>=0) 
            pathSum += leftVal;
        if(rightVal>=0)
            pathSum += rightVal;
        maxSum = Math.max(pathSum, maxSum);
        maxSum = Math.max(maxSum, root.val);
        
        //return max path val
        return Math.max(Math.max(leftVal, rightVal)+root.val, root.val);
    }
}