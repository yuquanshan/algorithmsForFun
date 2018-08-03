/** Given an array with n objects colored red, white or blue, 
* sort them so that objects of the same color are adjacent, 
* with the colors in the order red, white and blue.
*
* Here, we will use the integers 0, 1, and 2 to represent 
* the color red, white, and blue respectively.
*
* Note:
* You are not suppose to use the library's sort function for this problem.
*
* public void sortColors(int[] nums)
*/
import java.util.*;

public class SortThreeColors{
	public static void sortColors(int[] nums){
		if(nums == null || nums.length <= 1)
			return;
		int r = 0, b = nums.length - 1;
		int p = 0;
		while(p <= b){
			if(nums[p] == 0){
				nums[p++] = nums[r];
				nums[r++] = 0;
			}else if(nums[p] == 2){
				nums[p] = nums[b];
				nums[b--] = 2;
			}else{
				p++;
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {1,0,1,2,0};
		System.out.println(Arrays.toString(nums));
		sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
} 