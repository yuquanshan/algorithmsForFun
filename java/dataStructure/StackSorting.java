/**
* given a stack, re-sort it with the largest element on the top.
* public static void stackSorting(Stack<Integer> stack)
* (there is a shorter algorithm which i failed to give for the first time)
*/
import java.util.*;

public class StackSorting{
	public static void stackSorting(Stack<Integer> stack){
		if(!stack.empty()){
			Stack<Integer> secstack = new Stack<Integer>();
			int smallestSoFar = stack.pop();
			int left = 0;
			while(!stack.empty()){
				if(smallestSoFar > stack.peek()){
					secstack.push(smallestSoFar);
					smallestSoFar = stack.pop();
				}else{
					secstack.push(stack.pop());
				}
				left++;
			}
			stack.push(smallestSoFar);
			while(!secstack.empty()){
				stack.push(secstack.pop());
			}
			while(left > 1){
				smallestSoFar = stack.pop();
				for(int i = 0; i < left-1; i++){
					if(smallestSoFar > stack.peek()){
						secstack.push(smallestSoFar);
						smallestSoFar = stack.pop();
					}else{
						secstack.push(stack.pop());
					}
				}
				left--;
				stack.push(smallestSoFar);
				while(!secstack.empty()){
					stack.push(secstack.pop());
				}
			}
		}
	}
	public static void stackSortingConciser(Stack<Integer> stack){
		Stack<Integer> secstack = new Stack<Integer>();
		while(!stack.empty()){
			secstack.push(stack.pop());
		}
		while(!secstack.empty()){
			int curr = secstack.pop();
			if(stack.empty()){
				stack.push(curr);
			}else{
				while(!stack.empty()&&curr<stack.peek()){
					secstack.push(stack.pop());
				}
				stack.push(curr);
			}
		}
	}
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(4);
		stack.push(2);
		stack.push(1);
		stack.push(3);
		stackSortingConciser(stack);
		System.out.println("Sorting result is:");
		while(!stack.empty()){
			System.out.format("|%d|\n",stack.pop());
		}
	}
}