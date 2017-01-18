/** Implement next permutation, which rearranges numbers into 
* the lexicographically next greater permutation of numbers.
*
* If such arrangement is not possible, it must rearrange it 
* as the lowest possible order (ie, sorted in ascending order).
* 
* The replacement must be in-place, do not allocate extra memory.
*
* Here are some examples. Inputs are in the left-hand column and 
* its corresponding outputs are in the right-hand column.
* 1,2,3 → 1,3,2
* 3,2,1 → 1,2,3
* 1,1,5 → 1,5,1
*
* public void nextPermutation(int[] nums)
*/
import java.util.*;

public class NextPermutation{
	public static void nextPermutation(int[] nums){
		if(nums == null || nums.length <= 1)
			return;
		int tpos = -1;
		for(int i = nums.length-2; i>=0; i--){
			if(nums[i]<nums[i+1]){
				tpos = i;
				break;
			}
		}
		if(tpos == -1){
			reverseRange(nums,0,nums.length-1);
		}else{
			int t = nums[tpos];
			int j = tpos+1;
			while(j<nums.length && nums[j] > t)
				j++;
			j--;
			int tmp = nums[j];
			nums[j] = nums[tpos];
			nums[tpos] = tmp;
			for(int i = j; i > tpos+1; i--){
				if(nums[i]>nums[i-1]){
					int temp = nums[i];
					nums[i] = nums[i-1];
					nums[i-1] = temp;
				}else
					break;
			}
			reverseRange(nums,tpos+1, nums.length-1);
		}
	}
	private static void reverseRange(int[] nums, int start, int end){
		for(int i = start; i<start+(end-start+1)/2; i++){
			int tmp = nums[i];
			nums[i] = nums[end-i+start];
			nums[end-i+start] = tmp;
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,3,2};
		System.out.println(Arrays.toString(nums));
		nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}
} 