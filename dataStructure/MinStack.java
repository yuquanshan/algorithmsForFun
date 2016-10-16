/**
* implement a stack with a min() function which return the 
* minimum element in the stack.
public class MinStack {
    public MinStack() {}
    public void push(int number) {}
    public int pop() {}
    public int min() {}
}
*/
import java.util.*;

public class MinStack {
    private Stack<Integer> stack1;	// vanilla stack
    private Stack<Integer> stack2;	// records the min elements the according element in stack1 has seen so far
    public MinStack() {
    	stack1 = new Stack<Integer>();
    	stack2 = new Stack<Integer>();
    }
    public void push(int number) {
    	stack1.push(number);
    	if(stack2.isEmpty()){
    		stack2.push(number);
    	}else{
    		if(number<stack2.peek()){
    			stack2.push(number);
    		}else{
    			int j = stack2.peek();
    			stack2.push(j);
    		}
    	}
    }
    public int pop() {
    	stack2.pop();
    	return stack1.pop();
    }
    public int min() {
    	return stack2.peek();
    }
    public static void main(String[] args) {
    	MinStack stack = new MinStack();
    	stack.push(3);
    	stack.push(1);
    	stack.push(2);
    	System.out.format("The min element in the stack is %d.\n",stack.min());
    }
}