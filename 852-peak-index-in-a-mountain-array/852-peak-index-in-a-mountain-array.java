class Solution {
/**
comparing with the arr[i] > arr[i+1]
        f f f f t t t inf
        0 1 2 3 4 5 6 7
nums = [0,1,2,3,4,3,2,1]
left            ^
right                 ^
mid               ^  
                  ^
**/
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length-1;
        int peak = -1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            
            if(arr[mid] > arr[mid+1]){
                peak = mid;
                right = mid-1;
            }
            else
                left = mid+1;
        }
        return peak;
    }
}