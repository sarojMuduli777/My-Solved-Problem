class MyQueue {

    Stack<Integer> mainStack;
    Stack<Integer> tempStack;

    public MyQueue() {
        mainStack = new Stack<>();
        tempStack = new Stack<>();
    }
    
    public void push(int x) {
        if (mainStack.isEmpty()) {
            mainStack.push(x);
        } else {
            while (!mainStack.isEmpty()) {
                tempStack.push(mainStack.pop());
            }
            mainStack.push(x);
            while (!tempStack.isEmpty()) {
                mainStack.push(tempStack.pop());
            }
        }
    }
    
    public int pop() {
        return !mainStack.isEmpty() ? mainStack.pop() : -1;
    }
    
    public int peek() {
        return mainStack.isEmpty() ? -1 : mainStack.peek();
    }
    
    public boolean empty() {
        return mainStack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */