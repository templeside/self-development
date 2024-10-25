class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);
        int n = intervals.length;
        List<int[]> returnVal = new ArrayList<>();
        returnVal.add(intervals[0]);
        
        int[] prev= returnVal.get(0);
        for(int i=1; i<n; i++){
            int[] curr = intervals[i];
            
            //if overlapps,  prev[1]>= curr[0]
            if(prev[1]>= curr[0]){
                prev[1] = Math.max(prev[1], curr[1]);
            }else{
                returnVal.add(curr);
                prev = returnVal.get(returnVal.size()-1);
            }
        }
        int[][] returnArr = new int[returnVal.size()][2];
        for(int i=0; i< returnVal.size(); i++){
            returnArr[i] = returnVal.get(i);
        }
        return returnArr;
    }
}