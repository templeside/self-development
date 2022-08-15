class rowNode{
    public int idx;
    public int[] row;
    
    public rowNode(int[] row){
        this.idx =0;
        this.row = row;
    }
    
    public int getVal(){
        return row[idx];
    }
    public boolean shiftNext(){
        if(idx == row.length-1)
            return false;
        idx++;
        return true;
    }
}
class Solution {
    /**
    we can iterate each rows, and find the kth smallest number.
    **/
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<rowNode> queue = new PriorityQueue<>((a,b)-> a.getVal() - b.getVal());
        for(int[] row: matrix){
            queue.add(new rowNode(row));
        }
        
        int count = 1;
        while(count < k){
            rowNode currRow = queue.poll();

            if(currRow.shiftNext())
                queue.add(currRow);

            count ++;
        }
        return queue.poll().getVal();
    }
}