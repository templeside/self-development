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
    class Node{
        public double maxAverage;
        public int num;
        public int totalSum;
        
        public Node(double m, int n, int t){
            this.maxAverage = m;
            this.num = n;
            this.totalSum = t;
        }
    }
    
    public double maximumAverageSubtree(TreeNode root) {
        return dfs(root).maxAverage;
    }
    
    public Node dfs(TreeNode root){
        if(root ==null)//base case
            return new Node(0.0,0,0);
        
        Node left = dfs(root.left);
        Node right = dfs(root.right);
        
        int total = left.totalSum + right.totalSum + root.val;
        int num = left.num + right.num +1;
        double avg = (double)total/num;
        avg = avg>=left.maxAverage? avg: left.maxAverage;
        avg = avg>=right.maxAverage? avg: right.maxAverage;
        Node curr = new Node(avg, num, total);
        
        return curr;
        
    }
}