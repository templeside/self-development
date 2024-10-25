class Solution {
    /*
    find the condition where find first arr[i]>=arr[i+1]
    */
    public int peakIndexInMountainArray(int[] arr) {
        int left =0, right = arr.length-2;
        int peak = -1;
        
        while(left<=right){
            int mid = left+(right-left)/2;
            if(arr[mid]>= arr[mid+1]){
                peak = mid;
                right = mid-1;
            }else
                left = mid+1;
        }
        return peak;
    }
}