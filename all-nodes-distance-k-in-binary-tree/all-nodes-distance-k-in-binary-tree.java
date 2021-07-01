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
    HashMap<TreeNode, TreeNode> parent;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        dfs(root, null);
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(null);
        q.add(target);
        
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        seen.add(null);
        
        int dist = 0;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr == null){
                if(dist == k){
                    List<Integer> ans = new ArrayList<>();
                    for(TreeNode n: q)
                        ans.add(n.val);
                    return ans;
                }
                
                q.offer(null);
                dist ++;
            }else{
                if(!seen.contains(curr.left)){
                    seen.add(curr.left);
                    q.offer(curr.left);
                }
                if(!seen.contains(curr.right)){
                    seen.add(curr.right);
                    q.offer(curr.right);
                }
                if(!seen.contains(parent.get(curr))){
                    seen.add(parent.get(curr));
                    q.offer(parent.get(curr));
                        
                }
            }
            
            
            
        }
        
        return new ArrayList<Integer>();
    }
    
    private void dfs(TreeNode curr, TreeNode par){
        if(curr !=null){
            parent.put(curr, par);
            dfs(curr.left, curr);
            dfs(curr.right, curr);
        }

    }
}