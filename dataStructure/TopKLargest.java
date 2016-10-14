/**
* given an array of number, the top k largetest number in the array
* public static int[] topk(int[] nums, int k)
*/
import java.util.*;

public class TopKLargest{
	public static int[] topk(int[] nums, int k){
		if(nums == null || nums.length <= k)
			return nums;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for(int i=0; i<nums.length; i++){
			if(heap.size()>=k){
				if(nums[i]>heap.peek()){
					heap.poll();
					heap.add(nums[i]);
				}	
			}else{
				heap.add(nums[i]);
			}
		}
		int[] res = new int[k];
		for(int i=0; i<k; i++){
			res[i] = heap.poll();
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {3,10,1000,-99,4,100};
		int k = 3;
		System.out.format("The array is %s, the top %d largest elements are %s.\n", Arrays.toString(nums),k,Arrays.toString(topk(nums,k)));
	}
}