class Solution {
    /*
    sort the costs - [b-a]
    smaller goes to b
    bigger goes to a
    criteria is the gap to make the price slower
    price diff = b-a
    [[10,20],[30,200],[400,50],[30,20]]
        10      170     -350     -10
    */
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b)-> (a[1]-a[0])-(b[1]-b[0]));
        int costSum = 0;
        
        int n =costs.length;
        for(int i=0; i< n/2; i++){
            int[] cost= costs[i];
            costSum += cost[1];
        }
        for(int i=n/2; i< n; i++){
            int[] cost= costs[i];
            costSum += cost[0];
        }
        return costSum;
    }
}