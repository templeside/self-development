/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
/**
lca 
1. p is on lca
2. q is on lca

non lca
3. left and right lca
4. only found left
5. only found right

base case null
return the ancestor.
            3
       (5)       1
    6    2     0  8   
        7  4

5,4
**/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        // case 2 in above figure
        if (root.equals(p) || root.equals(q)) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // case 1
        if (left != null && right != null) return root;

        // at this point, left and right can't be both non-null
        // case 4 and 5, report target node or LCA back to parent
        if (left != null) return left;
        if (right != null) return right;

        // case 4, not found return null
        return null;
    }
}