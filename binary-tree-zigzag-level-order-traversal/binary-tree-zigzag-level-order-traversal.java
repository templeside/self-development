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
        
        List<List<Integer>> ans = new LinkedList<>();
        if(root ==null) return ans;
        
        LinkedList<TreeNode> currLevel = new LinkedList<>();
        LinkedList<TreeNode> nextLevel = new LinkedList<>();
        boolean inorder = true;
        
        nextLevel.add(root);
        while(!nextLevel.isEmpty()){
            currLevel = nextLevel;
            nextLevel = new LinkedList<>();
            List<Integer> ansLevel = new LinkedList<>();
            
            while(!currLevel.isEmpty()){
                TreeNode curr = currLevel.poll();
                
                if(curr.left !=null)
                    nextLevel.add(curr.left);
                if(curr.right !=null)
                    nextLevel.add(curr.right);
                
                if(inorder){
                    ansLevel.add(curr.val);
                }else{
                    ansLevel.add(0, curr.val);
                }
            }
            
            ans.add(ansLevel);
            inorder = !inorder;
        }
        return ans;
    }
}