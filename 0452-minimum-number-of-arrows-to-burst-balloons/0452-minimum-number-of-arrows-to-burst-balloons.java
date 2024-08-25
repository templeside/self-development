class Solution {
    /*
    sort interval
    
    find overlapping.
    if not finding overlapping, increment.
    
    */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        int count = 1;
        int prevEnd = points[0][1];
        int n = points.length;
        
        for(int i=1; i<n; i++){
            int[] curr = points[i];
            
            System.out.println(prevEnd< curr[0]);
                
            if(prevEnd <curr[0]){
                count++;
                prevEnd = curr[1];
            }
        }
        return count;
    }
}