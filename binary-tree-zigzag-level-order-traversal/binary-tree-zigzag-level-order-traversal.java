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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root ==null)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        
        LinkedList<TreeNode> currLevel = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
        
        nextLevel.add(root);
        
        while(!nextLevel.isEmpty()){
            currLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
            ArrayList<Integer> answerLevel = new ArrayList();
            
            while(!currLevel.isEmpty()){
                TreeNode currNode = currLevel.poll();
                
                if(currNode.left!=null)
                    nextLevel.add(currNode.left);
                if(currNode.right !=null)
                    nextLevel.add(currNode.right);
                
                if(ans.size()%2 == 1)//when 'ans' is odd 홀 수 일때
                    answerLevel.add(0, currNode.val);
                else// 짝 수 일때
                    answerLevel.add(currNode.val);
            }
            // 여기서 answer의 level close 하기
            ans.add(answerLevel);
        }
        return ans;
    }
}