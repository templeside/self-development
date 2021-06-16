class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        // last list 빼올 수 있는거: linkedList
        LinkedList<int[]> result = new LinkedList<>();
        for(int[] interval: intervals){
            if(result.isEmpty() || result.getLast()[1]<interval[0])
                result.add(interval);
            else
                result.getLast()[1] = Math.max(result.getLast()[1],interval[1]);
        }
        return result.toArray(new int[result.size()][2]);
    }
}