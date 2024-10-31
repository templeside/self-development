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
    have the preorder and inorder traversal.
    preorder - it can keep in the range of 
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

        3
    9       20
          15   7

the preorder takes out the level [3,9,20,15,7]
                                   |    |
inorder defines the left, right [9,3,15,20,7]
                                   ^
                                   
preorder - currRoot
inorder - left, right.
val.left = leftval
val.right = rightval
how to find the root then?
    preorder - define root.
    global preorderIdx - keep track of curr root
    
    inorder - define left, right range
    
    */
    public int preorderIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        // <inorderval, idx>
        Map<Integer, Integer> inorderMap = new HashMap<>();
        preorderIdx = 0;
        for(int i=0; i<n; i++){
            inorderMap.put(inorder[i], i);
        }
        int left=0;
        int right = n-1;
        return recursion(left, right, preorder, inorder, inorderMap);
    }
    
    public TreeNode recursion(int left, int right, int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap){
        if(left> right)
            return null;
        
        TreeNode currRoot = new TreeNode(preorder[preorderIdx]);
        preorderIdx++;
        
        int currRootInorderIdx = inorderMap.get(currRoot.val);
        
        currRoot.left = recursion(left, currRootInorderIdx-1, preorder, inorder, inorderMap);
        currRoot.right = recursion(currRootInorderIdx+1, right, preorder, inorder, inorderMap);
        
        return currRoot;
    }
}