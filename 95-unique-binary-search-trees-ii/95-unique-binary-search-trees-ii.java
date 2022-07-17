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
        return backtrack(1, n);
    }
    
    public LinkedList<TreeNode> backtrack(int startIdx, int endIdx){
        LinkedList<TreeNode> returnVal = new LinkedList<>();
        
        if(startIdx>endIdx){
            returnVal.add(null);
            return returnVal;
        }
        
        for(int i=startIdx; i<=endIdx;i++){
            LinkedList<TreeNode> leftNodes = backtrack(startIdx, i-1);
            LinkedList<TreeNode> rightNodes = backtrack(i+1, endIdx);
            
            for(TreeNode leftNode: leftNodes){
                for(TreeNode rightNode: rightNodes){
                    TreeNode currNode= new TreeNode(i);
                    currNode.left = leftNode;
                    currNode.right = rightNode;
                    returnVal.add(currNode);
                }
            }
        }
        return returnVal;
    }
}