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
class BSTIterator {
    int[] idx;
    List<Integer> stored_val;
    public BSTIterator(TreeNode root) {
        idx = new int[]{-1};
        stored_val = new ArrayList<>();
        dfs(root);
    }
    private void dfs(TreeNode root){
        if(root ==null) return;
        
        dfs(root.left);
        
        stored_val.add(root.val);
        
        dfs(root.right);
    }
    
    
    public int next() {
        idx[0]++;
        if(idx[0] >= stored_val.size())
            return -1;
        return stored_val.get( idx[0]);
    }
    
    public boolean hasNext() {
        return idx[0] <stored_val.size()-1;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */