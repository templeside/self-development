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
    check the binary search tree in order.
    if we check through dfs withinorder traversal, comparing prevNode < currNode
    it is valid.

    left recursion

    compare with prev node

    right recursion
    */
    public TreeNode prev ;
    public boolean isValidBST(TreeNode root) {
        if(root ==null)
            return true;
        
        if(!isValidBST(root.left))
            return false;

        if(prev!= null && prev.val>= root.val)
            return false;
        prev = root;
        
        return isValidBST(root.right);
    }
}