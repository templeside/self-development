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
/*
BST means it is in order,
so we can do in order traversal and return the kth smallest element 
return 
    -1: when null
    
recursion:
    left
    ---
    check left node
    check current node
    
    right
[5,3,6,2,4,null,null,1]
k=3

       5
     /  \
    3    6
    /\   /\
   2 4  n  n
  /
 1
/
n
*/
class Solution {
    public static int k;
    public int kthSmallest(TreeNode root, int a) {
        k=a;
        return inorder(root);
    }
    public int inorder(TreeNode root){
        if(root == null)return -1;
        
        int left = inorder(root.left);
        
        if( left != -1)
            return left;
        k--;
        if(k==0)
            return root.val;
        
        int right = inorder(root.right);
        return right;
    }
}