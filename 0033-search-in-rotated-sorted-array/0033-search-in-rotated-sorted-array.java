class Solution {
    /*
    find starting point
    closing point    
         0 1 2 3 4 5 6
        [4,5,6,7,0,1,2]     target=0
left           ^
right          ^
mid            ^          3+(5-3)/2 = 4
         0 1 2 3 4 5 6
        [4,5,6,7,0,1,2]     target=0
endIdx         ^
    */
    public int search(int[] nums, int target) {
        if(nums.length == 0)
            return -1;

        if(nums.length == 1)
            return nums[0] == target? 0: -1;
        
        int endIdx = findEnd(nums);
        System.out.println("end index is "+endIdx+" "+nums[endIdx]);
        if(nums[0]<= target && target<=nums[endIdx])
            return find(0, endIdx, target, nums);
        if(nums[endIdx+1]<= target && target<= nums[nums.length-1])
            return find(endIdx+1, nums.length-1, target, nums);
        return -1;
    }
    
    public int findEnd(int[] nums){
        int left=0;
        int right = nums.length-2;
        
        while(left<=right){
            
            int mid = left+(right-left)/2;
            System.out.println("left is:"+left+" right is:"+right+ " mid is:"+mid);
            if(nums[mid]> nums[mid+1]){
                return mid;
            }
            else if(nums[left]<= nums[mid])
                left = mid+1;
            else
                right =mid-1;
        }
        return 0;
    }
    
    /*
         0 1 2 3 4 5 6
        [4,5,6,7,0,1,2]     target=0
endIdx         ^
    */
    public int find(int left, int right, int target, int[] nums){
        System.out.println(left+" "+right);
        while(left<=right){
            int mid = left+(right-left)/2;
            int midVal = nums[mid];
            if(midVal == target){
                return mid;
            }else if(midVal>target){
                right = mid-1;
            }else
                left = mid+1;
        }
        return -1;
    }
}