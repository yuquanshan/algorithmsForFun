/**
given an array of colors red(0), white(1), blue(2), sort them in the orer of 
red, white, blue.
public static void sort(int[] nums)
(didn't know the one-pass approach in the first time)
*/
import java.util.*;

public class SortColors{
	public static void sort(int[] nums){
		if(nums != null && nums.length > 1){
			int redidx = 0;
			int blueidx = nums.length-1;
			int i = 0;
			while(i < blueidx){
				if(nums[i] == 0){
					nums[i] = nums[redidx];
					nums[redidx] = 0;
					redidx += 1;
					i++;
				}else if(nums[i] == 2){
					nums[i] = nums[blueidx];
					nums[blueidx] = 2;
					blueidx -= 1;
				}else{
					i++;
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {2,0,0,1,2,0,2};
		System.out.format("Current array is %s.\n",Arrays.toString(nums));
		sort(nums);
		System.out.format("Sorted array is %s.\n",Arrays.toString(nums));
	}
}