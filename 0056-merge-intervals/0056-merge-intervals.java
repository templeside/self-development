class Solution {
    /*
    
    */  
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        
        LinkedList<int[]> returnList = new LinkedList<>();
        
        int[] prev= null;
        for(int[] interval: intervals){
            if(prev == null || prev[1]< interval[0]){
                returnList.add(interval);
                prev = returnList.get(returnList.size()-1);
            }else{
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }
        return returnList.toArray(new int[returnList.size()][2]);
    }
}