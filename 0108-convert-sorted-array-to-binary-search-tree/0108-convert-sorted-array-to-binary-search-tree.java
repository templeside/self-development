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
    find middle
    middle = root
    root.left = middle [0, middle-1]
    root.right = [middle+1, n-1]
    
     

     [-10,-3,0,5,9]
     0     1 2 3 4
    mid = 0+4/2 = 2
    */
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        
        return recursion(left, right, nums);
    }
    
    public TreeNode recursion(int left, int right, int[] nums){
        if(left> right)
            return null;
        
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = recursion(left,mid-1,nums);
        root.right = recursion(mid+1, right, nums);
        return root;
    }
}