/** Count of Smaller Numbers After Self
* You are given an integer array nums and you have to return a new counts array. 
* The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
*
* Example:
* Given nums = [5, 2, 6, 1]
* To the right of 5 there are 2 smaller elements (2 and 1).
* To the right of 2 there is only 1 smaller element (1).
* To the right of 6 there is 1 smaller element (1).
* To the right of 1 there is 0 smaller element.
* Return the array [2, 1, 1, 0].
*
* public List<Integer> countSmaller(int[] nums)
*/
import java.util.*;

public class CountOfSmallerAfter{
	public static List<Integer> countSmaller(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0)
			return res;
		int[] lastSmaller = new int[nums.length];
		int[] tmp = new int[nums.length];
		tmp[nums.length-1] = 0;
		lastSmaller[nums.length-1] = nums.length;
		for(int i = nums.length-2; i>=0; i--){
			int j = i+1;
			while(j != nums.length && nums[j]>=nums[i]){
				j = lastSmaller[j];
			}
			lastSmaller[i] = j;
			if(j == nums.length)
				tmp[i] = 0;
			else{
				tmp[i] = tmp[j]+1;
			}
		}
		for(int i: tmp){
			res.add(i);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {5,2,6,1};
		List<Integer> res = countSmaller(nums);
		System.out.println(res.toString());
	}
}