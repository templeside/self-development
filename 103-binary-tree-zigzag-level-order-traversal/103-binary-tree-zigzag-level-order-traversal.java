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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root ==null)return new ArrayList();
        List<List<Integer>> returnVal = new ArrayList<>();
        List<Integer> currLevelReturnVal;
        List<TreeNode> currLevel;
        List<TreeNode> nextLevel = new ArrayList<>();
        
        boolean reversed = false;
        nextLevel.add(root);
        
        while(nextLevel.size() !=0){
            currLevel = nextLevel;
            nextLevel = new ArrayList<>();
            currLevelReturnVal = new LinkedList<>();
            
            while(currLevel.size()!=0){
                TreeNode curr = currLevel.remove(0);
                if(reversed) currLevelReturnVal.add(0,curr.val);
                else currLevelReturnVal.add(curr.val);
                
                if(curr.left !=null)
                    nextLevel.add(curr.left);
                if(curr.right !=null)
                    nextLevel.add(curr.right);
            }
            reversed = !reversed;
            returnVal.add(currLevelReturnVal);
        }
        return returnVal;
    }
}