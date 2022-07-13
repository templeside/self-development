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
    /**          0  1 2 3 4 
Input: nums = [-10,-3,0,5,9]
preorder traversal.
            
find mid, mid, mid.
Output: [0,-3,9,-10,null,5]

    */
    public TreeNode sortedArrayToBST(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int left =0, right =nums.length-1;
        return recursion(left,right, nums, visited);
    }
    public TreeNode recursion(int left, int right, int[] nums, boolean[] visited){
        int mid = left+(right-left)/2;
        if(left> right|| visited[mid])return null;
        
        TreeNode currNode = new TreeNode(nums[mid]);
        visited[mid] = true;
        
        currNode.left = recursion(left, mid-1, nums, visited);
        currNode.right = recursion(mid+1,right,nums,visited);
        
        return currNode;
    }
}