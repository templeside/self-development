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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = helper(nums, 0,nums.length-1);
        return root;
    }
    
    public TreeNode helper(int[] nums, int left, int right){
        if(left> right)return null;
        if(left == right){
            TreeNode returnNode = new TreeNode( nums[left]);
            return returnNode;
        }
        
        int mid = left+(right-left)/2;
        TreeNode returnNode = new TreeNode(nums[mid]);
        
        returnNode.left = helper(nums, left, mid-1);
        returnNode.right = helper(nums, mid+1, right);
        
        return returnNode;
    }
}