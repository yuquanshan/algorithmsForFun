/** 
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * class StackWithQueues {
 *   public MyStack() {}
 *   public void push(int x) {}
 *   public int pop() {}
 *   public int top() {}
 *   public boolean empty() {}
 * }
 */
import java.util.*;

class StackWithQueues {
	Queue<Integer> queue0;
    /** Initialize your data structure here. */
    public StackWithQueues() {
    	queue0 = new LinkedList<Integer>();
  	}
    
    /** Push element x onto stack. */
    public void push(int x) {
    	queue0.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()) return 0;
        int size = queue0.size();
        while(size > 1) {
        	queue0.add(queue0.poll());
        	size--;
        }
        return queue0.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if (empty()) return 0;
        int size = queue0.size();
        while(size > 1) {
            queue0.add(queue0.poll());
            size--;
        }
        int res = queue0.poll();
        queue0.add(res);
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue0.isEmpty();
    }
}