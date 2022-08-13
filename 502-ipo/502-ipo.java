class Solution {
    /**
    having the project and the profit can be leveraged.
    I would have hashmap<capital, PriorityQueue<profit>> to track down the least number I could get.
    
    time complexity will going to be good.
    
k       1
w       10
profits [1,2,3]
captical[0,0,0]
    **/
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> capitalSize = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        PriorityQueue<int[]> profitSize = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        
        for(int i=0; i< profits.length; i++){
            capitalSize.add(new int[]{capital[i], profits[i]});
        }
        
        for(int i=0; i<k; i++){
            while(!capitalSize.isEmpty() && capitalSize.peek()[0] <= w){
                profitSize.add(capitalSize.poll());
            }
            
            if(profitSize.isEmpty()) break;
            
            w += profitSize.poll()[1];
        }
        return w;
    }
}