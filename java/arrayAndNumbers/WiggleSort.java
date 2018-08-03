/**
* given an array, sort the array such that 
* nums[0] <= nums[1] >= nums[2] <= nums[3]...
* public static void wiggleSort(int[] nums)
*/
import java.util.*;

public class WiggleSort{
	public static void wiggleSort(int[] nums){
		if(nums.length>=2){
			for(int i = 1; i<nums.length; i++){
				if(i%2 == 1){
					if(nums[i] < nums[i-1]){
						int tmp = nums[i-1];
						nums[i-1] = nums[i];
						nums[i] = tmp;
					}
				}else{
					if(nums[i] > nums[i-1]){
						int tmp = nums[i-1];
						nums[i-1] = nums[i];
						nums[i] = tmp;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {3,5,2,1,6,4};
		System.out.format("The original array is %s\n",Arrays.toString(nums));
		wiggleSort(nums);
		System.out.format("The wiggle-sorted array is %s\n", Arrays.toString(nums));
	}
}