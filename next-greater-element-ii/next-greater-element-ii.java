class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] outputArr = new int[n];
        Arrays.fill(outputArr, -1);
        
        Stack<Integer> stack = new Stack();
        for(int i=0; i<n*2; i++){
            
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]){
                outputArr[stack.pop()] = nums[i%n];
            }
            
            if( i<n) stack.push(i);
        }
        return outputArr;
    }
}