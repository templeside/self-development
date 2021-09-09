class Solution {
    private HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public int minCostClimbingStairs(int[] cost) {
        return minimumCost(cost.length, cost);
    }
    
    private int minimumCost(int i, int[]cost){
        if(i<=1)        //base case
            return 0;
        
        if(memo.containsKey(i))
            return memo.get(i);
    
        int downOne = cost[i-1] + minimumCost(i-1,cost);
        int downTwo = cost[i-2] + minimumCost(i-2, cost);
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }
}