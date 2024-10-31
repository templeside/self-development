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
    backtrack the values
    
    backtrack(currPath, currSum, root, target, returnVal)
    
    if(root ==null)
        return;
    
    currSum += root.val
    
    check currSum == target
    if( same, then add to returnVal)
    
    look for children
        add currval to path
        backtrack child with added currSum
        remove currval from path
    */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> currPath = new ArrayList<>();
        List<List<Integer>> returnVal = new ArrayList<>();
        int currSum =0;
        
        backtrack(currPath, currSum, targetSum, root, returnVal);
        return returnVal;
    }
    public void backtrack(List<Integer> currPath, int currSum, int targetSum, TreeNode root, List<List<Integer>> returnVal){
        if(root ==null)
            return;
        if(root.left ==null & root.right ==null){
            currSum += root.val;
            currPath.add(root.val);

            if(currSum == targetSum){
                returnVal.add(new ArrayList(currPath));
            }    
            currPath.remove(currPath.size()-1);

            return;
        }
        
        currSum += root.val;
        currPath.add(root.val);
        
        if(root.left !=null)
            backtrack(currPath, currSum, targetSum, root.left, returnVal);
        if(root.right !=null)
            backtrack(currPath, currSum, targetSum, root.right, returnVal);
        
        currPath.remove(currPath.size()-1);
    }
}