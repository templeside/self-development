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
    need a global updates. 
    global updates in the new things...... 그게 무엇일까....?
    
    having left subtree, right subtree.
    currSum = left+right + current.
    comparing those three values and return max...이라기엔 once path is returning, its returning weird value.
    instead we are returning the left most edges sum and right most edges sum.
    
    global path sum..for tracking the maxPathSum.
    
    so instead, we are having algorithm:
    return value: max edges sum
    
    recursion:
        left = recursion(root.left)
        right = recursion(root.right)
        
        currPath = left+right+curr.val;
        update path
        return max(left, right)+ curr.val;
    */
    public static int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        postOrder(root);
        return maxSum;
    }
    public int postOrder(TreeNode root){
        if(root ==null)return 0;
        
        int left = Math.max(postOrder(root.left),0);
        int right = Math.max(postOrder(root.right),0);
        
        int currPath = left+right+ root.val;
        maxSum = Math.max(currPath, maxSum);        //
        
        return Math.max(left, right)+ root.val;
    }
}