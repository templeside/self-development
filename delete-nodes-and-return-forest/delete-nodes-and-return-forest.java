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
    Set<Integer> to_delete_set;
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        to_delete_set = new HashSet<>();
        res = new ArrayList<>();
        for(int i: to_delete){
            to_delete_set.add(i);
        }
        helper(root, true);
        return res;
    }
    private TreeNode helper(TreeNode root, boolean is_root){
        if(root ==null)return null;
        boolean deleted = to_delete_set.contains(root.val);
        if(is_root && !deleted) 
            res.add(root);
        root.left = helper(root.left, deleted);
        root.right = helper(root.right, deleted);
        return deleted? null: root;
    }
}