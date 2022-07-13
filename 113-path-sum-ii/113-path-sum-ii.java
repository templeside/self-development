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
    // doing the recursion, top down recursive, if reach to the each leaf, compare withthe value and add it to the global return value.
    // backtracking.
    // base case is when return null.
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> returnVal  = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        int currSum = 0;
        backtrack(returnVal, currPath, currSum, root, targetSum);
        return returnVal;
    }
    
    public void backtrack(List<List<Integer>> returnVal, List<Integer> currPath, int currSum, TreeNode root, int targetSum){
        if(root==null)return;
        
        currPath.add(root.val);
        currSum += root.val;
        
        if(root.left ==null && root.right == null && currSum == targetSum){
            returnVal.add(new ArrayList<>(currPath));
        }
        backtrack(returnVal, currPath, currSum, root.left, targetSum);
        backtrack(returnVal, currPath, currSum, root.right, targetSum);
        
        currPath.remove(currPath.size()-1);
    }
}