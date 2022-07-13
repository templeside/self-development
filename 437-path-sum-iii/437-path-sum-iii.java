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
Given the root of a binary tree and an integer targetSum, 
return the number of paths where the sum of the values along the path equals targetSum.

1. having the queue to check the target sum,  compare with the queue.
2. considering two possibilities: in path or not in path.
        
        10
    5       -3
 3     2        11
3 -2    1
        
Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
Explanation: The paths that sum to 8 are shown.
        

baseCase
returnVal
**/
class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        List<Integer> dataSaver = new ArrayList<>();
        return dfs(root, targetSum, dataSaver);
    }
    
    public int dfs(TreeNode root, int targetSum, List<Integer> dataSaver){
        if(root ==null) return 0;
        
        dataSaver.add(root.val);
        
        int tempSum= 0;
        int count =0;
        for(int i=dataSaver.size()-1; i>=0 ;i--){
            tempSum += dataSaver.get(i);
            if(tempSum == targetSum)
                count++;
        }
        
        int leftCount = dfs(root.left, targetSum, dataSaver);
        int rightCount = dfs(root.right, targetSum, dataSaver);
        
        dataSaver.remove(dataSaver.size()-1);
        
        return count+leftCount+rightCount;
    }
}