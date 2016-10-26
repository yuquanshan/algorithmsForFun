/**
* given a array representing a histogram, find the area of 
* largest rectangle in the histogram.
* public static int largestRectangleArea(int[] height)
* (failed to give a correct answer on time in the first time, 
* spent three days (2016/10/18-20) to understand the stack approach)
*/
import java.util.*;

public class LargestRectangleInHistogram{
	public static int largestRectangleArea(int[] height){
		if(height == null || height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();	// stack below the top is the last element smaller than the top
		int maxSoFar = 0;
		for(int i = 0; i <= height.length; i++){
			int curr = (i<height.length)?height[i]:-1;
			while(!stack.isEmpty() && height[stack.peek()]>=curr){
				int indx = stack.pop();
				if(stack.isEmpty())
					maxSoFar = (i*height[indx]>maxSoFar)?i*height[indx]:maxSoFar;
				else
					maxSoFar = ((i-stack.peek()-1)*height[indx]>maxSoFar)?(i-stack.peek()-1)*height[indx]:maxSoFar;
			}
			stack.push(i);
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		int[] height = {3,5,5,2,5,5,6,6,4,4,1,1,2,5,5,6,6,4,1,3};
		System.out.format("The array is %s, the largest rectangular area is %d.\n",Arrays.toString(height),largestRectangleArea(height));
	}
}