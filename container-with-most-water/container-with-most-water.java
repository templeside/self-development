class Solution {
    public int maxArea(int[] height) {
        int left =0, right = height.length-1;
        int difference;
        int output =0;
        
        while(left<right){
            // int col = Math.min(height[left], height[right]);
            // System.out.println(col);
            output = Math.max(Math.min(height[left], height[right])*(right-left), output);
            
            if(height[left]>height[right]){
                right--;
            }else{
                left++;
            }
        }
        return output;
    }
}