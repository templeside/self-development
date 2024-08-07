class Solution {
    /*
matrix = [[1,5,9],
          [10,11,13],
          [12,13,15]], k = 8
having a class to save index of each row.
i do have a heap which goes the smallest as first.
iterate 8 times.
    */
    class Node{
        public int idx;
        public int[] arr;
        public Node(int[] arr){
            idx =0;
            this.arr = arr;
        }
        public int getVal(){
            return arr[idx];
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> queue = new PriorityQueue<>((a,b)-> a.getVal() - b.getVal());
        for(int[] arr : matrix){
            queue.add(new Node(arr));
        }
        for(int i=0; i< k-1; i++){
            Node curr = queue.poll();
            curr.idx ++;
            if(curr.idx< curr.arr.length)
                queue.add(curr);
            
        }
        return queue.poll().getVal();
    }
}