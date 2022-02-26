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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root ==null)return new ArrayList<>();
        
        List<List<Integer>> returnVal = new ArrayList<>();
        List<Integer> currReturnVal;
        
        List<TreeNode> currLevel;
        List<TreeNode> nextLevel = new ArrayList<>();
        nextLevel.add(root);
        
        while(nextLevel.size() !=0){
            currLevel = nextLevel;
            currReturnVal = new ArrayList<>();
            nextLevel = new ArrayList<>();
            
            while(currLevel.size()!=0){
                TreeNode curr = currLevel.remove(0);
                currReturnVal.add(curr.val);
                
                if(curr.left!=null)
                    nextLevel.add(curr.left);
                if(curr.right !=null)
                    nextLevel.add(curr.right);
            }
            returnVal.add(0,currReturnVal);
        }
        return returnVal;
        
    }
}