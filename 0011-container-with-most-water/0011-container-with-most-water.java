class Solution {
    /*
    always would be great to have left and right height.
    left and right wall should be the max val.
        if left or right is updated, update the maxWater
    idx              0 1 2 3 4 5 6 7 8
    Input: height = [1,8,6,2,5,4,8,3,7]
    maxLeft        0 1 8 8 8 8 8 8 8 8 8
    left                 ^
    maxRight       8 8 8 8 8 8 8 8 7 7 0 
    right                            ^
    area = (right-left)* (Min(left,right))
    area =  8-1 (7) 49
    
    1. find maxLeft
    2. find maxRight
    3. have two pointers
    4. update area by updating input
    */
    public int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;
        // find maxLeft
        int[] maxLeft = new int[n];
        for(int i=0; i<n; i++){
            if(i ==0){
                maxLeft[i] = height[i];
                continue;
            }
            maxLeft[i] = Math.max(maxLeft[i-1], height[i]);
        }
        
        // find maxRight
        int[] maxRight= new int[n];
        for(int i=n-1; i>=0; i--){
            if(i ==n-1){
                maxRight[i] = height[i];
                continue;
            }
            maxRight[i] = Math.max(maxRight[i+1], height[i]);
        }
        
        // have two pointers
        int left=0, right=n-1;
        
        // update area by updating input
        while(left<right){
            //check area & 
            int area = (right-left)* Math.min(maxLeft[left], maxRight[right]);
            //update input
            maxArea = Math.max(area, maxArea);
            
            if(maxLeft[left]< maxRight[right]){
                left++;
            }else
                right--;
        }
        return maxArea;
    }
}