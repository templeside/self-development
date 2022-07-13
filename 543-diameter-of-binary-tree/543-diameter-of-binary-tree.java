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
/**
base case - when null, return 0.

compare left, right
compare with global variable(left+right-1).

return - the length of the max path/

dim(1) = dim(2)+dim(3)-
dim(2) = 1
dim(4) = 0
dim(5) = 0
*/
class Solution {
    public int dim;
    public int diameterOfBinaryTree(TreeNode root) {
        dim = 0;
        recursion(root);
        return dim;
    }
    
    public int recursion(TreeNode root){
        if(root ==null) return 0;
        
        int left = recursion(root.left);
        int right = recursion(root.right);
        dim = Math.max(dim, left+right);
        
        return Math.max(left, right)+1;
    }
}