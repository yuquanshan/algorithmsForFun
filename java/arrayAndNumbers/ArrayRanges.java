/**
* given a sorted array without duplicates, return the summaray of its ranges.
* for example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
* public static List<String> ranges(int[] nums){}
*/
import java.util.*;

public class ArrayRanges{
	public static List<String> ranges(int[] nums){
		int i = 0;
		List<String> res = new ArrayList<String>();
		while(i < nums.length){
			String tmp = Integer.toString(nums[i]);
			int num = nums[i++];
			int temp = num;
			while(i < nums.length && temp+1 == nums[i]){
				temp = nums[i++];
			}
			if(temp != num)
				tmp = tmp+"->"+Integer.toString(temp);
			res.add(tmp);
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {0,1,2,4,5,7};
		System.out.format("Given %s, we have %s.\n", Arrays.toString(nums), ranges(nums).toString());
	}
}