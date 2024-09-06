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
    having global variable to keep in track the kth smallest element
    */
    public int kth = 1;
    public int returnVal;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return returnVal;
    }
    public void inorder(TreeNode root, int k){
        if(root ==null)
            return;
        
        inorder(root.left, k);
        
        if(kth == k)
            returnVal = root.val;
        kth ++;
        
        inorder(root.right, k);
    }
}