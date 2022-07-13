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
    이걸 어떻게 표현 할 건데????????
    미친 또라이 쉐퀴들아
    개새꺄
    죽여버리고 시퍼
    ㅎㅎ
    when curr is LCA
    1. left & right is p and q
    2. one is under the another
    
    when curr is not LCA
    3. no p or q
    4. in path
    5. in subtree.
    
    base case when null
    
    return p or q or lowest common ancestor.
    */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root ==null)return null; // 
        
        if(root == p || root == q)return root;// #2
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p,q);
        
        if(left !=null&& right !=null) return root; // #1
        if(left !=null) return left;    //#4, #5
        if(right !=null) return right;  //#4, #5
        
        return null;
    }
}