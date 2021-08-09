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
    boolean pFound = false;
    boolean qFound = false;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = LCA(root, p, q);
        return pFound && qFound? lca : null;
    }
    
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        if(root ==null)return root;
        
        TreeNode left = LCA(root.left, p,q);
        TreeNode right = LCA(root.right, p, q);
        
        if(root ==p){
            pFound = true;
            return root;
        }
        
        if(root ==q){
            qFound = true;
            return root;
        }
        
        return left ==null ? right : right == null? left :root;
    }
}