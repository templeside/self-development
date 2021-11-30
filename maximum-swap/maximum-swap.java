class Solution {
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
                // <number, latest index>
        int[] bucket = new int[10];
        
        for(int i=0; i< arr.length;i++){
            int n = arr[i]-'0';
            bucket[n] = i;
        }
        
        for(int numIdx =0; numIdx< arr.length; numIdx++){
            for(int n = 9; arr[numIdx] -'0'<n; n--){
                if(numIdx<bucket[n]){
                    char tmp = arr[numIdx];
                    arr[numIdx] = arr[bucket[n]];
                    arr[bucket[n]] = tmp;
                    
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;
    }
}