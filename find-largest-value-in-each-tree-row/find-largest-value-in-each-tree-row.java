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
    public List<Integer> largestValues(TreeNode root) {
        if(root ==null)return new ArrayList<>();
        // 1. find max on each level
        List<Integer> res = new ArrayList<>();
        
        Queue<TreeNode> currLevel = new ArrayDeque<>();
        Queue<TreeNode> nextLevel = new ArrayDeque<>();
        nextLevel.add(root);
        
        while(!nextLevel.isEmpty()){
            currLevel = nextLevel;
            nextLevel = new ArrayDeque<>();
            int levelMax = Integer.MIN_VALUE;
            
            while(!currLevel.isEmpty()){
                TreeNode currNode = currLevel.poll();
                levelMax = Math.max(levelMax, currNode.val);
                
                if(currNode.left!=null)
                    nextLevel.add(currNode.left);
                if(currNode.right !=null)
                    nextLevel.add(currNode.right);
            }
            res.add(levelMax);
                
        }
        return res;
    }
}