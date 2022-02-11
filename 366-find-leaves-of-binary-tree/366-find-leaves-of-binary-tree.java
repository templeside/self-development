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
    List<List<Integer>> returnArr;
    public List<List<Integer>> findLeaves(TreeNode root) {
        returnArr = new ArrayList<>();
        dfs(root);
        
        // int len = returnArr.size();
        // for(int i=0; i< len/2;i++){
        //     List<Integer> temp = returnArr.get(i);
        //     returnArr.set(i, returnArr.get(len-1-i));
        //     returnArr.set(len-1-i, temp);
        // }
        return returnArr;
    }
    
    public int dfs(TreeNode root){
        if(root ==null)return -1;

        int left = dfs(root.left);
        int right = dfs(root.right);
        
        int currHeight = Math.max(left,right)+1;
        
        if(returnArr.size()== currHeight)
            returnArr.add(new ArrayList<>());
        List<Integer> depth_level = returnArr.get(currHeight);
        depth_level.add(root.val);
        
        return currHeight;
    }
}