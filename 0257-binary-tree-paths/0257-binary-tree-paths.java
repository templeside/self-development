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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<String> currPath = new ArrayList<>();
        backtrack(root, currPath, paths);
        return paths;
    }
    public void backtrack(TreeNode root, List<String> currPath, List<String> paths){
        if(root.left ==null && root.right == null){
            currPath.add(Integer.toString(root.val));
            paths.add(String.join("->", currPath));
            currPath.remove(currPath.size()-1);
            return;
        }
        
        currPath.add(Integer.toString(root.val));
        if(root.left !=null){
            backtrack(root.left, currPath, paths);
        }
        if(root.right !=null){
            backtrack(root.right, currPath, paths);
        }
        currPath.remove(currPath.size()-1);
        return;
    }
}