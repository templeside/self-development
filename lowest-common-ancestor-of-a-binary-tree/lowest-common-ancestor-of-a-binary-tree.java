public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)          //cuzz there won't be a same p and q
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);  //left child
        TreeNode right = lowestCommonAncestor(root.right, p, q);    // right child
        if(left != null && right != null)   
            return root;
        return left != null ? left : right;
    }
}
