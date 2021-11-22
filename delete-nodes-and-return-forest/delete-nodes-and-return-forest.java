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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> deleteSet = new HashSet<>();
        List<TreeNode> ans = new LinkedList<>();
        if(root ==null)return ans;
        
        for(Integer i: to_delete)
            deleteSet.add(i);

        if(recurse(root, deleteSet, ans)!=null)
            ans.add(root);
        return ans;
    }
    private TreeNode recurse(TreeNode root, Set<Integer> deleteSet, List<TreeNode> ans){
        if(root ==null) return null;

        root.left = recurse(root.left, deleteSet, ans);
        root.right = recurse(root.right, deleteSet, ans);
                if(deleteSet.contains(root.val)){
            if(root.left !=null)
                ans.add(root.left);
            if(root.right !=null)
                ans.add(root.right);
            return null;
        }
        return root;
    }
}