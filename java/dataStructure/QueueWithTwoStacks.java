/**
* implement a queue with two stacks
public class QueueWithTwoStacks{
	private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public Queue(){}
    public void push(int element){}
    public int pop(){}
    public int top(){}	
}
* (failed to come up with a on-average O(1) algorithm in the first time)
*/
import java.util.*;

public class QueueWithTwoStacks{
	private Stack<Integer> stack1;	// let it be in stack
    private Stack<Integer> stack2;	// let it be out stack
    public QueueWithTwoStacks(){
    	stack1 = new Stack<Integer>();
    	stack2 = new Stack<Integer>();
    }	
    public void push(int element){
    	stack1.push(element);
    }
    public int pop(){
    	/*
    	say initially you have n elements in stack1, to dequeue you need to 
    	pour all elements in stack2, which costs O(n), however, in the following 
    	n-1 dequeues, you just need O(1), so on average it's O(n)/n = O(1) time.
    	*/
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.pop();
    }
    public int top(){
    	if(stack2.isEmpty()){
    		while(!stack1.isEmpty()){
    			stack2.push(stack1.pop());
    		}
    	}
    	return stack2.peek();
    }	
    public static void main(String[] args) {
    	QueueWithTwoStacks queue = new QueueWithTwoStacks();
    	queue.push(1);
    	queue.push(2);
    	queue.push(3);
    	System.out.format("Dequeue result is %d\n.",queue.pop());
    }
}