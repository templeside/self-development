class Solution {
  public static void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  public static int[] findErrorNums(int[] nums) {
    int i=0, n= nums.length; 
    int[] returnval = new int[] { -1, -1 };
    
    while( i< n){
      int currVal = nums[i];
      if(nums[i] == i+1 || nums[currVal-1] == currVal)
        i++;
      else
        swap(nums, i, currVal-1);
    }

    for(i=0; i<n; i++){
      if(nums[i] != i+1){
        returnval[1] = i+1;
        returnval[0] = nums[i];
      }

    }
    return returnval;
  }
}