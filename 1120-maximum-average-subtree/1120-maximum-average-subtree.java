class Solution {
    private double res = 0;
    public double maximumAverageSubtree(TreeNode root) {
        helper(root);
        return res;
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0, 0}; // sum, num
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int[] curSub = new int[]{left[0] + right[0] + root.val,
                                left[1] + right[1] + 1};
        res = Math.max(res, (double) curSub[0] / (double) curSub[1]);
        return curSub;
    }
}