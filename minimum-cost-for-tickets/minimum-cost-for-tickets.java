class Solution {
/**
    1
$2   $7   $15
4   8       
**/
    int[] costs;    // [1daycost, 7daycost, 30daycost]
    HashMap<Integer, Integer> memo; // <days와 money sum>
    Set<Integer> dayset;    // days given
    
    public int mincostTickets(int[] days, int[] costs) {
        this.costs = costs;
        memo = new HashMap<>();
        dayset = new HashSet();
        for(int d: days)
            dayset.add(d);
        return dp(1);
    }
    
    public int dp(int i){
        if(i>365)
            return 0;
        if(memo.containsKey(i)) // if(contains some integer, that means it is covered by passes, and return the sum)
            return memo.get(i);
        
        int ans;
        if(dayset.contains(i)){
            ans = Math.min(dp(i+1)+ costs[0], dp(i+7)+ costs[1]);
            ans = Math.min(ans, dp(i+30)+costs[2]);
        }else{
            ans = dp(i+1);
        }
        
        memo.put(i, ans);
        return ans;
    }
}