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
    public List<TreeNode> generateTrees(int n) {
        return backtrack(1,n);
    }
    public LinkedList<TreeNode> backtrack(int startIdx, int endIdx){
        LinkedList<TreeNode> returnVal = new LinkedList<TreeNode>();
        if( startIdx>endIdx){
            returnVal.add(null);
            return returnVal;
        }
        
        for(int i = startIdx; i<=endIdx; i++){
            
            LinkedList<TreeNode> left = backtrack(startIdx, i-1);
            LinkedList<TreeNode> right = backtrack(i+1, endIdx);
            
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode currNode = new TreeNode(i);
                    currNode.left = l;
                    currNode.right = r;
                    returnVal.add(currNode);
                }
            }
        }
        return returnVal;
    }
}