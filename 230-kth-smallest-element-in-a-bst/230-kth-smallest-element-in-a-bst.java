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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> returnval = new ArrayList<Integer>();
        inOrder(root, returnval);
        return returnval.get(k-1);
    }
    
    public void inOrder(TreeNode root, ArrayList<Integer> returnval){
        if(root == null)return;
        
        inOrder(root.left, returnval);
        
        returnval.add(root.val);
        
        inOrder(root.right,returnval);
        return;
    }
}