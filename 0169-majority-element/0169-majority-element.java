class Solution{
    public int majorityElement(int[] nums){
        int count =0;
        Integer Candidate = null;
        
        for(int num: nums){
            if(count ==0){
                Candidate = num;
            }
            
            count += (num==Candidate)? 1: -1;
        }
        return Candidate;
    }
}