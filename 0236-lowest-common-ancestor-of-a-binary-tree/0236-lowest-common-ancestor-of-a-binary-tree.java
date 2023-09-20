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
    /*
      3
     /  \
    5    1
    /\   /\
   6  2  08
      /\
     7  4
     
    6,1
    
      3
     /  \
     6   1
    /\   /\
   6  n  08
      /\
     n  n
     
    recursion should be post order.
    why?? because there is no way expecting which values will come out.
    purpose - matching lowest common ancestor
    
    basecase - node is null         
    return - 1. found one         
                a. root             - return root
                b. one of child     - return child
             2. found two           
                a. root & child     - return root
                b. child & child    - return root
                
    recursion
        left = recursion(left)
        right = recursion(right)
        
        if(root == p|q)
            1.a if(child ==null)
            2.a if(one of child !=null)
            return root
            else return root
        if(child & child !=null)
            return root
        if(one child)
            return the child
        else
            return false
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        
        TreeNode left = lowestCommonAncestor(root.left, p,q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        
        if(root == p || root == q)
            return root;
        else if(left != null && right !=null)
            return root;
        else if(left != null)
            return left;
        else if(right !=null)
            return right;
        else
            return null;
    }
}