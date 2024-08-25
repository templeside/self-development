class Solution {
    /*
    sort interval
    
    find overlapping.
    if not finding overlapping, increment.
    
    */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        int count = 1;
        int arrowPos = points[0][1];
        int n = points.length;
        
        for(int i=1; i<n; i++){
            int[] curr = points[i];
            
            if(arrowPos< curr[0]){
                count++;
                arrowPos = curr[1];
            }
        }
        return count;
    }
}