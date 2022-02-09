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
    double maxAverage;
    public double maximumAverageSubtree(TreeNode root) {
        maxAverage = 0;
        
        dfs(root);
        return maxAverage;
    }
    
    //returns [total sum of values, numers of values]
    public int[] dfs(TreeNode root){
        // if found bigger average, change the max average.
        if(root ==null)return new int[2];
        
        int totalSum = root.val;
        int num = 1;
        
        int[] left = dfs(root.left);        // left
        int[] right = dfs(root.right);      // right
        
        totalSum = totalSum+ left[0] + right[0];
        num = num+ left[1]+right[1];
        
        
        if((double)totalSum/num > maxAverage)
            maxAverage = (double)totalSum/num;
        
        int[] currStatus = new int[]{totalSum,num};
        return currStatus;
    }
}