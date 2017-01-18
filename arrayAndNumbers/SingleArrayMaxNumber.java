/**
* given an array of digits, find k digits such that they constructs 
* the max number possible while remaining their original positions.
* it's actually the simplified version of CreateMaxNumber.java
* for simplicity, just assume the length of array is greater than 
* or equal to k.
* public static int[] maxNumber(int[] nums)
* (a self-created problem ripped from CreateMaxNumber.java)
*/
import java.util.*;

public class SingleArrayMaxNumber{
	public static int[] maxNumber(int[] nums, int k){
		int[] res = new int[k];
		int len = 0;
		for(int i = 0; i<nums.length; i++){
			while(len > 0 && len+nums.length-i > k && nums[i]>res[len-1]){
				len--;
			}
			if(len < k)
				res[len++] = nums[i];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums = {1,3,8,5,3,5,0,0};
		int k = 3;
		int[] res = maxNumber(nums,k);
		System.out.format("The max number from %s is %s\n", Arrays.toString(nums),Arrays.toString(res)); 
	}
}