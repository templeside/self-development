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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] answer = new int[1];
        helper(root, answer);
        return answer[0];
    }
    public int helper(TreeNode root, int[] answer){
        if(root == null)
            return 0;
                
        int left = helper(root.left,answer);
        int right = helper(root.right,answer);
        
        if(left + right > answer[0])
            answer[0] = left+right;
        return Math.max(left, right)+1;
    }
}