/**
given a sequence of integers, find the length of longest increasing subsequence.
*/

// a smarter approach which is O(nlogn), ref https://en.wikipedia.org/wiki/Longest_increasing_subsequence
import java.util.*;

public class LongestIncreasingSubsequence{
	public static int longest(int[] nums){
		if(nums.length == 0)
			return 0;
		int len = 0; 	// keep track of the largest length
		int[] M = new int[nums.length+1];	// element is the index of the smallest last element of the subsequence with the length equal to the index
											// note that nums[M[i]] in increasing with i
		M[1] = 0;
		len = 1;
		for(int i = 1; i<nums.length; i++){
			int ind = findLargsetLessThan(nums, M, len, nums[i]);
			M[ind+1] = i;
			if(ind+1>len)
				len = ind+1;
		}
		return len;
	}
	public static int findLargsetLessThan(int[] nums, int[] M, int L, int target){ // find the highest index in M in which the element is smaller than the target
		int start = 1;
		int end = L;
		if(nums[M[1]] > target)
			return -1;
		while(end - start > 1){
			int mid = start + (end-start)/2;
			if(nums[M[mid]]<=target)
				start = mid;
			else
				end = mid;
		}
		if(nums[M[end]] < target)
			return end;
		else
			return start;
	}
	public static void main(String[] args) {
		int[] array = {4,2,4,5,3,7};
		System.out.println("The array is "+Arrays.toString(array));
		System.out.format("The length of the longest subsequence is %d.\n",longest(array));
	}
}