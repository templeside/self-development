class Solution {
    public int tribonacci(int n) {
        if(n <=2)
            return n==0 ? 0 : 1;
        
        int[] arr = new int[n+1];
        for(int i=0; i< arr.length;i++){
            arr[i] = -1;
        }
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        
        return tribo(arr, n);
    }
    private int tribo(int[] arr, int n){
        // 1. basecase n in the ranges, n !=-1
        // 2. get values
        // 3. store in arr
        // return.
        if(n<0 || arr[n] !=-1)
            return arr[n];
        
        int sum = tribo(arr, n-1)+ tribo(arr, n-2)+ tribo(arr, n-3);
        arr[n] = sum;
        return sum;
        
    }
}