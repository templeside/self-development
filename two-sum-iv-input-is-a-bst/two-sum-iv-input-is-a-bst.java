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
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer, TreeNode> set = new HashMap<Integer, TreeNode>();
        iterate(root, set);
        
        
        for(int i: set.keySet()){
            if(set.containsKey(k-i)){
                if(set.get(i) != set.get(k-i))
                    return true;
            }
        }
        return false;
    }
    
    public void iterate(TreeNode root, HashMap<Integer, TreeNode> set){
        if(root ==null)
            return;
        
        set.put(root.val, root);
        
        iterate(root.left, set);
        iterate(root.right, set);
    }
}