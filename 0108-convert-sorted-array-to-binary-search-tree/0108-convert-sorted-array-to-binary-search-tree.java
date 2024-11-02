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
       0  1 2 3 4
    [-10,-3,0,5,9]

mid = left+(right-left)/2;
left = [left, mid-1]
right = [mid+1, right]
    we get the middle, and define left or right
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        int leftIdx=0;
        int rightIdx=nums.length-1;
        return recursion(nums, leftIdx, rightIdx);
    }

    public TreeNode recursion(int[] nums, int leftIdx, int rightIdx){
        if(leftIdx> rightIdx)
            return null;

        int mid = leftIdx+(rightIdx-leftIdx)/2;

        TreeNode currRoot = new TreeNode(nums[mid]);
        currRoot.left = recursion(nums, leftIdx, mid-1);
        currRoot.right = recursion(nums, mid+1, rightIdx);

        return currRoot;
    }
}