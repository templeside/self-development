/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    /**
    1. lca itself
        -left lca
        -right lca
    2. no lca itself
        - left,right
        - no found left
        - no foung right
    1. starting from the root, recursion.
        if(found p or q) return root.
        if(not null)return 
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null)return null;
        
        if(root==p || root == q)return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        if(left !=null && right != null)return root;
        if(left !=null)return left;
        if(right !=null)return right;
        return null;
    }
}