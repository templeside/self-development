class Solution {
    /*
    to  think, If I do have left and right in order, I think I can do make space of specific color, and shift to the middle.
    if left and right side is sorted, then it should be fine with middle color - because there are three colors, and left and right side is sorted means only left the remaining one color.
    
    how to sort the color then?
    we would have iterator, left and right index.

    nums = [2,0,2,1,1,0]
iterator    ^          
left        ^
right                 ^
nums = [2,0,2,1,1,0]
nums = [0,0,2,1,1,2]
nums = [0,0,1,1,2,2]

    nums = [2,0,1]
    nums = [1,0,2]
iterator      ^
left        ^
right         ^
    iterator iterates:
        if(currVal == 0)
            exchane wit hleft
            left ++;
        if(currVal == 1)
            iterator ++
        if(currVal==2)
            exchange wit right
            right --;
        
    */
    
    public void sortColors(int[] nums) {
        int n = nums.length;
        int iterator =0, left=0, right=n-1;
        
        while(iterator<=right){
            int currVal = nums[iterator];
            
            if(currVal == 0){
                exchange(left, iterator, nums);
                left ++;
                iterator++;
                
            }
            else if(currVal ==1){
                
                iterator++;
            }
            else if(currVal ==2){
                exchange(right, iterator, nums);
                right --;
            }
        }
    }
    
    public void exchange(int i1, int i2, int[] nums){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}