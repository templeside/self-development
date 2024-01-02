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
    /*
    dfs: 
        nextRootIdx++
        mid value = preorder[nextRootIdx]에서 가져오고
        left, right range = inorder에서 mid 가져오고 given left, right검색.

        left = dfs(left, mid-1)
        right = dfs(mid+1, right)

        return node
    */
    public int currRootIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        //inorder의<value,idx>
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i=0; i<n; i++)
            inorderMap.put(inorder[i], i);
        
        currRootIdx = 0;
        int left =0, right = n-1;
        
        return dfs(left,right, preorder, inorder, inorderMap);
    }
    public TreeNode dfs(int left,int right, int[] preorder, int[] inorder, Map<Integer, Integer>inorderMap){
        if(left> right)return null;
        
        int currRootVal = preorder[currRootIdx];// midval
        currRootIdx++;
        
        TreeNode currRoot = new TreeNode(currRootVal);
        int midIdx = inorderMap.get(currRootVal);
        
        currRoot.left = dfs(left,midIdx-1, preorder, inorder, inorderMap);
        currRoot.right = dfs(midIdx+1,right, preorder, inorder, inorderMap);
        return currRoot;
    }
}