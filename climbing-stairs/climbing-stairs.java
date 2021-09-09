class Solution {
    public int climbStairs(int n) {
        if(n == 0) return n;    //base case
        
        int[] arr = new int[n+1];
        return helper(n,arr);
    }
    private int helper(int n, int[]arr){
        if(n<=0) return 0;      //base case
        if(n == 1) return 1;
        if(n == 2) return 2;
        if( arr[n] !=0)return arr[n];
        
        int currStep = helper(n-1,arr) + helper(n-2,arr);
        arr[n] = currStep;
        
        return currStep;
    }
}