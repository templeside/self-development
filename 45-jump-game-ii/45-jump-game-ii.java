class Solution {
    /**
    Input: nums = [2,3,1,1,4]
    dp =          [ ]
    Output: 2

    하나 하나씩 찾아가 보며 생각을 한다...? 그러면 어떻게 해야 이 들을 잡을 수 있을까?????
    dp table은 어떻게 찾아내면 될까???
    목표를 잡고 여기까지 도달할 수 있는지를 체크하는 것이다.
    
    예전의 내가 있는 곳에서 도달할 수 있는 것을 체크하는 게 아닌
    내가 있는 곳까지 올 수 있는 최대한의 노력들을 확인하는 것.
    DFS로 하게 되면 엄청나게 수월하게 만들 수 있을 것이다.
    그런데 그거 말고도 할 수 있는 방법이 있다.
    오잉 무엇일까?????
    
    tabulation을 통해 만들 수 있는 것.
    how????
    dp[idx] = minimum jump to get the works.
    **/
    public int jump(int[] nums) {
        int[] dp = new int[nums.length+1];
        
        for(int i=1; i< nums.length; i++)
            dp[i] = Integer.MAX_VALUE;
        
        for(int start = 0; start<nums.length-1; start++){
            for(int end = start+1; end<= start+nums[start] && end< nums.length; end++){
                dp[end] = Math.min(dp[end], dp[start]+1);
            }
        }
        return dp[nums.length-1];
    }
}