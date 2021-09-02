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
    public boolean findTarget(TreeNode root, int k) {
        // <num, count>
        HashMap<Integer, Integer> map =new HashMap<Integer,Integer>();
        dfs(root, k, map);
        for(int a: map.keySet()){
            if(map.containsKey(a)){
                map.put(a, map.get(a)-1);
                int diff = k-a;
                if(map.containsKey(diff) && map.get(diff)>0)
                    return true;
                else
                    map.put(a, map.get(a)+1);
            }
        }
        return false;
    }
    
    public void dfs(TreeNode root, int k, HashMap<Integer, Integer> map){
        if(root ==null)return;
        
        dfs(root.left, k, map);
        
        if(!map.containsKey(root.val)){
            map.put(root.val, 0);
        }
        map.put(root.val, map.get(root.val)+1);
        
        dfs(root.right, k, map);
        return;
    }
}