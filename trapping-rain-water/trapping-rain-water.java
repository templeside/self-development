class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] maxleft = new int[len];
        int[] maxright = new int[len];
        int left = 0, right =0;
        
        for(int i=0; i< len;i++){
            left = Math.max(left, height[i]);
            maxleft[i] = left;
            right = Math.max(right,height[len-i-1]);
            maxright[len-i-1] = right;
        }
        
        int waterCount = 0;
        for(int i=0;i<len;i++){
            int subtract = Math.min(maxleft[i], maxright[i]) - height[i];
            waterCount += subtract>0? subtract:0;
        }
        return waterCount;
    }
}