/**
given an array, find a subarray whose sum is closest to zero.
public int[] subarray(int[] nums)
O(nlogn) time.
run out of time in the first time.
*/
import java.util.*;

public class SubarraySumClosest{
	public static int[] subarray(int[] nums){
		if(nums == null || nums.length == 0)
			return null;
		int[] res = new int[2];
		int[] acc = new int[nums.length];
		int[] ind = new int[nums.length];
		int sum = 0;

		for(int i = 0; i < nums.length; i++){
			sum = sum + nums[i];
			acc[i] = sum;
			ind[i] = i;
		}
		//System.out.println(Arrays.toString(acc));
		doubleQuickSort(acc,ind,0,acc.length-1);
		//System.out.println(Arrays.toString(acc));
		//System.out.println(Arrays.toString(ind));
		int closestSoFar = Math.abs(acc[0]);
		res[0] = ind[0];
		res[1] = ind[0];
		for(int i = 1; i < nums.length - 1; i++){
			if(Math.abs(acc[i]-acc[i-1])<closestSoFar){
				if(ind[i] > ind[i-1]){
					res[0] = ind[i-1]+1;
					res[1] = ind[i];
				}else{
					res[0] = ind[i]+1;
					res[1] = ind[i-1];
				}
				closestSoFar = Math.abs(acc[i]-acc[i-1]);
			}
		}
		return res;
	}
	public static void doubleQuickSort(int[] nums, int[] ind, int start, int end){
		if(nums != null && end - start > 0){
			int i = start - 1;
			for(int j = start; j < end; j++){
				if(nums[j]<nums[end]){
					i += 1;
					int mid = nums[i];
					nums[i] = nums[j];
					nums[j] = mid;
					mid = ind[i];
					ind[i] = ind[j];
					ind[j] = mid;
				}
			}
			int mid = nums[i+1];
			nums[i+1] = nums[end];
			nums[end] = mid;
			mid = ind[i+1];
			ind[i+1] = ind[end];
			ind[end] = mid;
			doubleQuickSort(nums,ind,start,i);
			doubleQuickSort(nums,ind,i+2,end);
		}
	}
	public static void main(String[] args) {
		int[] nums = {-3,1,1,-3,5};
		System.out.format("The array is %s.\n",Arrays.toString(nums));
		int[] res = subarray(nums);
		System.out.format("One subarray whose sum is closest to zero is from %d to %d.\n",res[0],res[1]);
	}
}