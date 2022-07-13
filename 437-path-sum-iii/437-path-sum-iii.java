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
    /**
    1. iterate through recursion.
    2. compare with the values with the datasets containing currnt value.
    
    base case - when null
    
    do the iteration from the end. compare the values with target value.
    
    return - count.
    */
    public int pathSum(TreeNode root, int targetSum) {
        ArrayList<Integer> datas = new ArrayList<>();
        
        return recursion(root, targetSum, datas);
    }
    public int recursion(TreeNode root, int targetSum, ArrayList<Integer> datas){
        if(root ==null)return 0;
        
        datas.add(root.val);
        int tempSum = 0;
        int tempCount=0;
        for(int i= datas.size()-1; i>=0; i--){
            tempSum += datas.get(i);
            if(tempSum == targetSum)
                tempCount++;
        }
        
        tempCount += recursion(root.left, targetSum, datas);
        tempCount += recursion(root.right, targetSum, datas);
        
        datas.remove(datas.size()-1);
        return tempCount;
    }
}