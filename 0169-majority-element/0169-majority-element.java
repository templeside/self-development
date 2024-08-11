class Solution {
    /*
    3,3,4
num     ^ 
element 3
count 2
    */
    public int majorityElement(int[] nums) {
        Integer element = null;
        int count = 0;
        
        for(int num: nums){
            if(count == 0)
                element = num;
            
            count = element == num? count+1: count-1;
        }
        return element;
    }
}