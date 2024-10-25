class Solution {
    /*
Output: 2
Input: points = [[10,16],[2,8],[1,6],[7,12]]

shot up - is in x direction(vertical)
as much as shot up is important.

sort the points based on x-axis
pop out the baloon, check the xEnd
pop out all the points
    that the starting point of other points < xEnd
    
    Arrays.sort((a,b)-> a[0]-b[0])
    while(pop out is done){
        compare with curr value.
        if(curr.start> starting point.end)
            startingpoint = curr
            count++;
        else
            pop();
    }
    points = [[1,6],[2,8],[7,12],[10,16]]

    */
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)-> Integer.compare(a[1],b[1]));
        // if(points.length == 1)
            // return 1;



        int prevRange = points[0][1];
        int count=1;
        for(int[] point: points){
            if(prevRange< point[0]){
                count ++;
                prevRange = point[1];
            }
        }
        return count;
    }
}