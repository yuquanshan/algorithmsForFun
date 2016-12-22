/**
* if there is an arrays coming as a stream, return the list of 
* median-so-far when a new number comes in.
* public static int[] medianII(int[] nums){}
*/
import java.util.*;

public class DataStreamMedian{
	public static int[] medianII(int[] nums){
		if(nums == null || nums.length == 0)
			return null;
		PriorityQueue<Integer> leftHeap = new PriorityQueue<Integer>(nums.length/2+1,Collections.reverseOrder());
		PriorityQueue<Integer> rightHeap = new PriorityQueue<Integer>(nums.length/2+1);
		int[] res = new int[nums.length];
		for(int i = 0; i<nums.length; i++){
			if(i%2 == 0){
				if(leftHeap.isEmpty() || nums[i] >= leftHeap.peek()){
					rightHeap.add(nums[i]);
				}else{
					int tmp = leftHeap.poll();
					leftHeap.add(nums[i]);
					rightHeap.add(tmp);
				}
				res[i] = rightHeap.peek();
			}else{
				if(nums[i] <= rightHeap.peek()){
					leftHeap.add(nums[i]);
				}else{
					int tmp = rightHeap.poll();
					rightHeap.add(nums[i]);
					leftHeap.add(tmp);
				}
				res[i] = leftHeap.peek();
			}
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {4, 5, 1, 3, 2, 6, 0};
		int[] res = medianII(nums);
		System.out.format("Given %s, return %s\n",Arrays.toString(nums),Arrays.toString(res));
	}
}