/** Given an array nums, write a function to move all 0's 
* to the end of it while maintaining the relative order 
* of the non-zero elements.
*
* For example, given nums = [0, 1, 0, 3, 12], after calling 
* your function, nums should be [1, 3, 12, 0, 0].
* 
* Note:
* You must do this in-place without making a copy of the array.
* Minimize the total number of operations.
* public void moveZeroes(int[] nums)
*/
import java.util.*;

public class MoveZeros{
	public static void moveZeroes(int[] nums){
		if(nums == null || nums.length <= 1)
			return;
		int zslot = 0;	// slot spared by 0
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0){
				if(zslot < i)
					nums[zslot++] = nums[i];
				else
					zslot++;
			}
		}
		for(int i = zslot; i < nums.length; i++)
			nums[i] = 0;
	}
	public static void main(String[] args) {
		int[] nums = {0, 1, 0, 3, 12};
		System.out.println(Arrays.toString(nums));
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
	}
}