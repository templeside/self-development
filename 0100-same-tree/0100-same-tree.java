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
    recursion comparing together
    left, right
    return true or false
    recursion:
        if p==null && q ==null
            return true
        if p!=null || q !=null
            return false;
        
        if(p !=q)
            return false
            
        recursion(p.left, q.left)
        reqursion(p.right, q.right)
        return true
    */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        else if(p==null || q ==null)
            return false;
        
        if(p.val != q.val)
            return false;
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}