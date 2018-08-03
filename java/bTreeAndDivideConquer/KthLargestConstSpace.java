/**
* find kth largest element in the array, using constant 
* memory space.
* public static int kthLargestElement(int k, int[] nums)
* (failed to finish on time for the first time)
*/
import java.util.*;
public class KthLargestConstSpace{
	public static int kthLargestElement(int k, int[] nums){
		if(nums.length < k)
			return -1;
		return kthInRange(k,nums,0,nums.length-1);
	}
	public static int kthInRange(int k, int[] nums, int start, int end){
		int num = nums[end];
		int less = start-1;
		int pt = start;
		while(pt <= end-1){
			if(nums[pt]<num){
				less += 1;
				int mid = nums[less];
				nums[less] = nums[pt];
				nums[pt] = mid;
			}
			pt++;
		}
		nums[end] = nums[less+1];
		nums[less+1] = num;
		if(end - less == k)
			return num;
		if(end - less > k)
			return kthInRange(k,nums,less+2,end);
		else
			return kthInRange(k-end+less,nums,start,less);
	}
	public static void main(String[] args) {
		int k = 4;
		int[] nums = {7,10,4,3,1,2};
		System.out.format("The %dth largest element in %s is %d.\n", k, Arrays.toString(nums),kthLargestElement(k,nums));
	}
}