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
class BSTIterator{
    ArrayList<Integer> list;
    int nextIdx;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        nextIdx = 0;
        helper(root);
    }
    public void helper(TreeNode root){
        if(root ==null)return;
        
        //left
        if(root.left !=null)
            helper(root.left);
        
        list.add(root.val);
        
        // right
        helper(root.right);
        return;
    }
    
    public int next() {
        return list.get(nextIdx++);
    }
    
    public boolean hasNext() {
        return nextIdx<list.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */