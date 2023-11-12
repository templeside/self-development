class MinStack {
    /*
    stack operation
    push,
    pop,
    top
    getmin 
    
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

stack

0   -2
-2  -2  

valStack    currMinStack

-3              -3
0               -2
-2              -2

    */
    Stack<Integer> valStack;
    Stack<Integer> currMinStack;
    public MinStack() {
        valStack = new Stack<>();
        currMinStack = new Stack<>();
    }
    
    public void push(int val) {
        currMinStack.push(currMinStack.isEmpty()? val: Math.min(val,currMinStack.peek()));
        valStack.push(val);
    }
    
    public void pop() {
        currMinStack.pop();
        valStack.pop();
    }
    
    public int top() {
        return valStack.peek();
    }
    
    public int getMin() {
        return currMinStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */