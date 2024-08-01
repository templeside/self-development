class Solution {
    /*
i am only holding true statements.
    statements: arr[i] >= arr[i+1]
    
              f t t       
Input: arr = [0,2,1,0]
              ^     ^
              arr[i]> arr[i+1]
Output: 1

    */
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length-2;
        int peak = -1;
        
        while(left<=right){
            int mid = left +(right-left)/2;
            if(arr[mid]>= arr[mid+1]){
                peak = mid;
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return peak;
    }
}