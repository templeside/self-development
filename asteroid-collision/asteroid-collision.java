class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int asteroid = asteroids[i];
            if(asteroid>0){             //양수 일 때만 넣는다.
                stack.push(asteroid);
            }else{
                // 음수 일 때, stack.
                while(!stack.isEmpty() && stack.peek() >0 && stack.peek()< -asteroid) 
                    stack.pop();
                if(stack.isEmpty()|| stack.peek()<0) stack.push(asteroid);
                else if(stack.peek() == -asteroid) stack.pop(); //[10],5,-5
            }
        }
        int[] result = new int[stack.size()];
        for(int i=result.length-1; i>-1;i--)
            result[i] = stack.pop();
        return result;
    }
}