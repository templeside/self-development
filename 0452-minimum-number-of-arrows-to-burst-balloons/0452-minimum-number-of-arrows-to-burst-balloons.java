class Solution {
    /*
    trying to find the number of arrows to shot the balloons at most
    
    find out the ranges.
    I want the balloons to be sorted first. point[0], ascending, point[1] ascending
    then, calculate arrows
    
    [[1,6],[2,8],[7,12],[10,16]]
        ^
    based on the first iterator, check the following balloon range.
    6 - first two
    7 - two 
    
    time - O(NlogN)
    space - O(N)
    */
    public int findMinArrowShots(int[][] points) {
        // PriorityQueue<int[]> queue= new PriorityQueue<>((a,b)-> {
        //     if(a[0]-b[0] !=0) return a[0]-b[0];
        //     else return a[1]-b[1];
        // });
            
        PriorityQueue<int[]> queue= new PriorityQueue<>((a,b)-> Integer.compare(a[1], b[1]));
        for(int[] point: points){
            queue.add(point);
        }
        
        //initialize
        int counter = 1;
        int firstEnd = queue.peek()[1];
        
        int[][] arr = queue.toArray(new int[queue.size()][]);
        for(int[] q: arr){
            System.out.println(q[0]+ " "+ q[1]);
        }
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            if(curr[0] > firstEnd){// base case - not in range
                counter++;
                firstEnd = curr[1];
                continue;
            }
            //in range
            continue;
        }
        return counter;
        
    }
}