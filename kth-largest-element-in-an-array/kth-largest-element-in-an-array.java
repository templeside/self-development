class Solution {
    public int findKthLargest(int[] nums, int k) {
        Stack<Integer> db = new Stack<Integer>();
        Stack<Integer> tempDb = new Stack<Integer>();
        for(int n: nums){
            if(db.isEmpty() || db.peek() <= n)
                db.push(n);
            else{
                while(!db.isEmpty() && n < db.peek()){     //move to tempDB
                    tempDb.push(db.pop());
                }
                db.push(n);
                
                while(!tempDb.isEmpty())
                    db.push(tempDb.pop());
            }
        }
        while(k>1){
            db.pop();
            k--;
        }
            
        return db.peek();
    }
}