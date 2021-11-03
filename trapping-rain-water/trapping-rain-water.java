class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] max_left = new int[len];
        int[] max_right = new int[len];
        int left = 0;
        int right = 0;
        
        for(int i=0; i< len;i++){
            left = Math.max(left, height[i]);
            max_left[i] = left;
            
            right =Math.max(right, height[len-i-1]);
            max_right[len-i-1] = right;
        }
        int watercount =0;
        
        for(int i=0; i<len;i++){
            int smaller = Math.min(max_left[i], max_right[i]);
            watercount += smaller> height[i]? smaller-height[i]: 0;
        }
        return watercount;
    }
}