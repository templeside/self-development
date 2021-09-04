class Solution {
    public int tribonacci(int n) {
        int[] arr = new int[38];
        
        return helper(n, arr);
    }
    public int helper(int n, int[] arr){
        if(n<=0) return 0;
        if(n==1) return 1;
        
        if(arr[n] !=0)return arr[n];
        
        int ans = helper(n-1, arr)+ helper(n-2, arr)+helper(n-3, arr);
        
        arr[n] = ans;
        return ans;
    
    }
}