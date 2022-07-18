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
    /**
    1. find the subroot with the bfs
    2. find check it is subroot.
    **/
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int i=0; i<n;i++){
                TreeNode currNode = q.poll();
                if(currNode.val == subRoot.val){
                    if(isValid (currNode, subRoot)) return true;
                }
                if(currNode.left !=null)
                    q.add(currNode.left);
                if(currNode.right !=null)
                    q.add(currNode.right);
            }
        }
        return false;
    }
    public boolean isValid(TreeNode r1, TreeNode r2){
        if(r1 ==null && r2 ==null)return true;
        if(r1 == null|| r2 ==null)return false;
        
        if(r1.val != r2.val)return false;
        return isValid(r1.left, r2.left) && isValid(r1.right, r2.right);
    }
}