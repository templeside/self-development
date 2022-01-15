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
        if(root ==null)return new ArrayList<>();
        List<String> returnVal = new ArrayList<>();
        
        dfs("", root,returnVal);
        return returnVal;
    }
    
    public void dfs(String ans, TreeNode root, List<String> returnVal){
        if( root != null){
            if(root.left == null && root.right == null){
                returnVal.add(ans+root.val);
                return;
            }
            else{
        
            dfs(ans+root.val +"->", root.left, returnVal);
            dfs(ans+ root.val +"->", root.right, returnVal);
            }
        }
    }
}