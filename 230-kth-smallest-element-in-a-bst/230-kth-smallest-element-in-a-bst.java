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
/**
kth smallest, which means i need to be in order.
through the in order k--.
if there is k==0

          3               k==
    1(0)     4
      2
      
    saving the returnValue.
    
    [5,3,6,2,4,null,null,1] k=3
            5
        3       6
      2   4       
    1
    
**/
class Solution {
    public Integer counter;
    
    public int kthSmallest(TreeNode root, int k) {
        counter = 0;
        return dfs(root, k);   //return the value.
    }
    public int dfs(TreeNode root, int k){
        if(root ==null) return -1;
        
        int left = dfs(root.left, k);
        if(left !=-1)return left;
        
        counter++;
        System.out.println(counter+" val is : " +root.val);
        if(counter==k)return root.val;
        
        int right = dfs(root.right, k);
        if(right !=-1)return right;
        
        return -1;
    }
}