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
    public TreeNode prev;
    public TreeNode returnVal;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        prev = null;
        inorder(root, p);
        return returnVal;
    }
    public void inorder(TreeNode root, TreeNode p){
        if(root ==null)
            return;
        
        inorder(root.left, p);
        
        if(prev == p)
            returnVal = root;
        prev = root;
        
        inorder(root.right, p);
    }
}