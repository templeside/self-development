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
    /*
    if prev is p, return the currRoot.
    if not found, return prev.
    */
    public TreeNode prev;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null)
            return null;
        prev = null;
        return inorder(root, p);
    }

    public TreeNode inorder(TreeNode root, TreeNode p){
        if(root ==null){
            return null;
        }

        TreeNode left = inorder(root.left, p);
        if(left !=null)
            return left;

        if(prev == p)
            return root;
        prev = root;

        return inorder(root.right, p);
    }
}