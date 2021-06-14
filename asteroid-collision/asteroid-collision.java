
class Solution {
    /*
    The data structure used here is Stack.
    Since, we only iterate through the array once, the time complexity is O(N).
    The maximum space occupied by the Stack can be N, thus space complexity is O(N)
    */
    public int[] asteroidCollision(int[] asteroids) {
        /* Processing the collisions */
        
        // Stack for storing asteroids that survive the collision
        Deque<Integer> st = new ArrayDeque<>();
        
        // Initializing the stack
        st.push(asteroids[0]);
        
        /* len - for storing length of asteroid array
           and later storing size of stack
           and also serves as index */
        // val - for storing value(size) of the i-th asteroid
        int len = asteroids.length, val;
        
        // iteration through asteroid array
        for(int i=1;i<len;i++){
            val = asteroids[i];
            // if asteroids[i]<0 we need to process further
            // otherwise we can simply push it to the stack
            if(val<0){
                /* destroying all asteroids of the stack whose
                   absolute value (size) is less than val */
                while(st.size()!=0&&st.peek()>0&&st.peek()<-1*val){
                    st.pop();
                }
                /* if there is any element remaining in stack
                 and that element is positive, we'll need to check
                 whether it has same size has val asteroid*/
                if(st.size()!=0&&st.peek()>0){
                    /* if top of the stack has an absolute value(size) 
                       less than val means both will be destroyed */
                    if(st.peek()==-1*val){ st.pop(); }
                } else{
                    // otherwise push val to stack
                    st.push(val);
                }
            } else{
                st.push(val);
            }
        }
        
        /* Creating the result array */
        
        len = st.size();
        int[] result = new int[len];
        
        /* The stack contains value in reverse order
           that is, last index of result is top of the
           stack. Thus, this loop stores values in result
           in reverse order*/
        while(st.size()!=0){
            result[--len]=st.pop();
        }
        
        return result;
    }
}

