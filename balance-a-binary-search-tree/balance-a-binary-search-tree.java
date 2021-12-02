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
    public TreeNode balanceBST(TreeNode root) {
        
        List<TreeNode> map = new ArrayList<>();
        dfs(map, root);
        
        int left =0;
        int right = map.size()-1;        
        return  construct(map, left, right);
        
    }
    private TreeNode construct (List<TreeNode> map, int left, int right){
        if(left> right) return null;
        

        int median = (left+right)/2;
        TreeNode ans = map.get(median);
        
        TreeNode left_root = construct(map, left, median-1);
        TreeNode right_root = construct(map, median+1, right);
        
        ans.left = left_root;
        ans.right =right_root;
        return ans;
        
    }
    
    
    private void dfs(List<TreeNode> map, TreeNode root){
        if(root ==null)return;
        
        dfs(map, root.left);
        
        map.add(root);
        
        dfs(map, root.right);
        return;
        
    }
}