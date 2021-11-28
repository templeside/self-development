class Solution {
    // [0,1,3,4] ocean
     // in this case, only  [3]
    // should array be in ordered?
    // need to start from right
    // get the max value of the ocean.
        
    public int[] findBuildings(int[] heights) {
        List<Integer> ans = new ArrayList<>();
        int max = -1;
        
        for(int i= heights.length-1; i>=0;i--){
            if(heights[i] >max){
                max = heights[i];
                ans.add(0,i);
            }
                
        }
        int[] ansArr = new int[ans.size()];
        for(int i=0; i<ans.size(); i++)
            ansArr[i] = ans.get(i);
        return ansArr;
    }
}