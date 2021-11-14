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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        while(root !=null){
            List<Integer> temp = new ArrayList<>();
            root = dfs(root, temp);
            ans.add(temp);
        }
        return ans;
    }
    private TreeNode dfs(TreeNode root, List<Integer> arr){
        if(root.left == null &&root.right == null){
            arr.add(root.val);
            return null;
        }
        
        if(root.left !=null)
            root.left = dfs(root.left, arr);
        if(root.right !=null)
            root.right = dfs(root.right, arr);
        return root;
    }
}