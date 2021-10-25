class Solution {
    public int fib(int n) {
        if(n ==0 || n==1)
            return n;
        int[] arr = new int[n+1];
        
        arr[0] = 0;
        arr[1] = 1;
        
        return dynamic(arr, n);
    }
    
    private int dynamic(int[] arr, int n){
        if(n <=0 || arr[n] !=0)
            return arr[n];
        
        int sum = dynamic(arr, n-1) + dynamic(arr, n-2);
        arr[n] = sum;
        return sum;
    }
    
}