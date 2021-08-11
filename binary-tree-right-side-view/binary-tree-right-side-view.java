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
        if(root == null) return new ArrayList<Integer>();// base case
        
        List<Integer> returnList= new ArrayList<Integer>();
        ArrayDeque<TreeNode> currLevel = new ArrayDeque<>();
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>();
        
        nextLevel.add(root);
        returnList.add(root.val);
        
        while(!nextLevel.isEmpty()){
            currLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
            
            while(!currLevel.isEmpty()){
                TreeNode curr =currLevel.poll();
                if(curr.left !=null)
                    nextLevel.add(curr.left);
                if(curr.right !=null)
                    nextLevel.add(curr.right);
            }
            
            if(!nextLevel.isEmpty()){
                int rightVal = nextLevel.peekLast().val;
                returnList.add(rightVal);                
            }

        }
        
        return returnList;
        
    }
}