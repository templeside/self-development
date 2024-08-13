class Solution {
    /*
    sorted array
        [2,7,11,15], target = 9
Output: [1,2]
    
    i could use two forloop
    two pointers:
    left, right
    shrink it down to find the value 
    */
    public int[] twoSum(int[] numbers, int target) {
        int idx1 = 0, idx2= numbers.length-1;
        
        while(idx1<idx2){
            int sum = numbers[idx1] + numbers[idx2];
            if(target == sum)
                return new int[]{idx1+1, idx2+1};
            else if(target> sum){
                idx1++;
            }else{
                idx2--;
            }
        }
        return null;
    }
}