class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int maxJump = 0;
        int jumpEnd = 0;
        
        for(int i=0;i<nums.length-1;i++){
            maxJump = Math.max(maxJump,i+nums[i]);
            
            if(jumpEnd == i){
                jumpEnd = maxJump;
                jump++;
            }
        }
        return jump;
    }
}