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
    List<List<Integer>> pathList = new LinkedList<>();
    List<Integer> path = new LinkedList<>();
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root ==null) return new LinkedList<>();
        helper(root, targetSum);
        return pathList;
    }
    
    public void helper(TreeNode root, int remainingSum ){
        if(root ==null)return;
        
        path.add(root.val);
        
        if(remainingSum == root.val && root.left==null && root.right ==null)
            pathList.add(new LinkedList<>(path));
        else{
            helper(root.left, remainingSum-root.val);
            helper(root.right,remainingSum-root.val);
        }
        
        path.remove(path.size()-1);
    }
}