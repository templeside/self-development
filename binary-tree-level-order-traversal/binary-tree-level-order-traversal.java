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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root ==null)return new ArrayList<>();
        List<List<Integer>> order = new ArrayList<>();
        
        LinkedList<TreeNode> currLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        
        nextLevel.add(root);
        
        while(!nextLevel.isEmpty()){
            currLevel = nextLevel;
            nextLevel = new LinkedList<>();
            List<Integer> currLevelOrder = new ArrayList<>();
            
            while(!currLevel.isEmpty()){
                TreeNode curr = currLevel.poll();
                currLevelOrder.add(curr.val);
                
                if(curr.left!=null)
                    nextLevel.add(curr.left);
                if(curr.right !=null)
                    nextLevel.add(curr.right);
            }
            order.add(currLevelOrder);
        }
        return order;
    }
}