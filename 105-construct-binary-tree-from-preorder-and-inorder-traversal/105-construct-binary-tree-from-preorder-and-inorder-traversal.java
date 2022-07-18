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
    public int preorderIterator;
    public HashMap<Integer,Integer> inorderIdxMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIterator = 0;
        inorderIdxMap = new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            inorderIdxMap.put(inorder[i], i);
        }
        int left =0, right = preorder.length-1;
        return inorderTraversal(preorder, left, right);
    }
    
    public TreeNode inorderTraversal(int[] preorder,int left,int right){
        if(left>right) return null;
        
        TreeNode currNode = new TreeNode(preorder[preorderIterator++]);
        
        int inorderIdx = inorderIdxMap.get(currNode.val);
        currNode.left = inorderTraversal(preorder,left, inorderIdx-1 );
        currNode.right = inorderTraversal(preorder, inorderIdx+1, right);
        return currNode;
    }
}