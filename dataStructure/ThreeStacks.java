/**
* implement three stacks by a single array.
* 	public class ThreeStacks {
*    	public ThreeStacks(int size) {}
*    	public void push(int stackNum, int value) {}
*    	public int pop(int stackNum) {}
*    	public int peek(int stackNum) {}
*   	public boolean isEmpty(int stackNum) {}
*	}
* (there is a more flexible solution with multiple supporting arrays
* which i failed to give for the first time)
*/
import java.util.*;

public class ThreeStacks{
	int[] tops;
	int[] next;
	int free;	// next free slot
	int[] array;
	public ThreeStacks(int size){
		tops = new int[3];
		array = new int[size];
		next = new int[size];
		free = 0;
		for(int i = 0; i<3; i++)
			tops[i] = -1;	// indicates all stacks are currently empty
		for(int i = 0; i<size; i++){
			next[i] = i+1;
		}
	}
    public void push(int stackNum, int value){
    	if(free != -1){
    		int mid = next[free];
    		next[free] = tops[stackNum];
    		tops[stackNum] = free;
    		array[free] = value;
    		if(mid >= 0 && mid < array.length)
    			free = mid;
    		else
    			free = -1;
    	}
    }
    public int pop(int stackNum) {
    	if(tops[stackNum] != -1){
    		int mid = tops[stackNum];
    		tops[stackNum] = next[mid];
    		next[mid] = free;
    		free = mid;
    		return array[mid];
    	}else{
    		return Integer.MIN_VALUE;
    	}
    }
    public int peek(int stackNum) {
    	if(tops[stackNum] != -1){
    		return array[tops[stackNum]];
    	}else{
    		return Integer.MIN_VALUE;
    	}
    }
   	public boolean isEmpty(int stackNum) {
   		return tops[stackNum] == -1;
   	}
   	public static void main(String[] args) {
   		ThreeStacks stack = new ThreeStacks(42);
   		stack.push(1,1);
   		System.out.format("stack pop: %d\n",stack.pop(1));
   		if(stack.isEmpty(1)){
   			System.out.println("stack 1 is empty, correct!");
   		}else{
   			System.out.println("incorrect!");
   		}
   		stack.tacks(42);
   	}
}