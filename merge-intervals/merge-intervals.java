class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        
        LinkedList<int[]> ans = new LinkedList<>();
        
        for(int[] interval: intervals){
            int[] last =null;
            if(!ans.isEmpty())
                last = ans.getLast();
            if(last == null || last[1] < interval[0] )
                ans.add(interval);
            else{
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        
        int[][] ansArr = new int[ans.size()][];
        for(int i=0; i<ans.size();i++){
            ansArr[i] = ans.get(i);
        }
        return ansArr;
    }
}