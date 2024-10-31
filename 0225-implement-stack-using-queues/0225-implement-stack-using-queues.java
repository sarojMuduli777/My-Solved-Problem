import java.util.*;

class MyStack {

    // One queue is Our mejor queue and another is for temperary use only.
    Queue<Integer> queueOne;
    Queue<Integer> queueTwo;

    public MyStack() {
        // Initalize both the queues.
        queueOne = new ArrayDeque<>();
        queueTwo = new ArrayDeque<>();
        
    }
    
    public void push(int x) {
        // if QueeuOne is empty then derectly add x into queueOne.
        if (queueOne.isEmpty()) {
            queueOne.add(x);
        } else {
            // if queueOne is not empty then remove all elements from queueOne and add them into queueTwo.            
            while (!queueOne.isEmpty()) {
                queueTwo.add(queueOne.poll());
            }
            // Then add new element in queuTwo.
            queueOne.add(x);
            
            // At the end add  all elements from queueTwo into queueOne.
            while (!queueTwo.isEmpty()) {
                queueOne.add(queueTwo.poll());
            }
        }
    }
    
    public int pop() {
        return queueOne.isEmpty() ? -1 : queueOne.poll();
    }
    
    public int top() {
        return queueOne.isEmpty() ? -1 : queueOne.peek();
    }
    
    public boolean empty() {
        return queueOne.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */