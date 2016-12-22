/**
* implement a stack with a min() function which return the 
* minimum element in the stack.
* public class MinStack {
*    public MinStack() {}
*    public void push(int number) {}
*    public int pop() {}
*    public int min() {}
* }
* (didn't come up with a good algorithm with constant extra space)
*/
import java.util.*;

public class MinStack {
    private Stack<Integer> stack;
    private int min;
    public MinStack() {
    	stack = new Stack<Integer>();
        min = 0;
    }
    public void push(int number) {
    	if(stack.empty()){
            stack.push(0);
            min = number;
        }else{
            if(number < min){
                stack.push(number-min);
                min = number;
            }else{
                stack.push(number-min);
            }
        }
    }
    public int pop() {
    	if(!stack.empty()){
            if(stack.peek()>=0){
                return min+stack.pop();
            }else{
                int res = min;
                min = res-stack.pop();
                return res;
            }
        }else{
            return -1;
        }
    }
    public int min() {
    	return min;
    }
    public static void main(String[] args) {
    	MinStack stack = new MinStack();
    	stack.push(3);
    	stack.push(1);
    	stack.push(2);
    	System.out.format("The min element in the stack is %d.\n",stack.min());
    }
}