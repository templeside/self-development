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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new ArrayList();
        List<Integer> returnVal = new ArrayList<>();
        
        List<TreeNode> currLevel = new ArrayList();
        List<TreeNode> nextLevel = new ArrayList();
        nextLevel.add(root);
        
        
        while(nextLevel.size()!=0){
            currLevel = nextLevel;
            nextLevel = new ArrayList();
            returnVal.add(currLevel.get(currLevel.size()-1).val);
            
            while(currLevel.size()!=0){
                TreeNode curr = currLevel.remove(0);
                
                if(curr.left!=null)
                    nextLevel.add(curr.left);
                if(curr.right!=null)
                    nextLevel.add(curr.right);
            }
        }
        
        return returnVal;
    }
}