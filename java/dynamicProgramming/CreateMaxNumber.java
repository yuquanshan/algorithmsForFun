/**
* given two arrays of digits (0-9), with length m and n, create the maximum 
* number of length k <= m+n. the relative order of the digits from the 
* same array must be preserved.
* public static int[] maxNumber(int[] nums1, int[] nums2, int k)
* (witnessed in Google interview)
* (failed to solve it for the first time)
* public int[] maxNumber(int[] nums1, int[] nums2, int k)
*/
import java.util.*;

public class CreateMaxNumber{
	public static int[] maxNumber(int[] nums1, int[] nums2, int k){
		int m = nums1.length;
		int n = nums2.length;
		int[] res = null;
		for(int i = Math.max(k-n,0); i<=Math.min(k,m); i++){
			int[] maxSub1 = maxSub(nums1,i);
			int[] maxSub2 = maxSub(nums2,k-i);
			int[] curMax = merge(maxSub1, maxSub2);
			if(compare(res,0,curMax,0) < 0)
				res = curMax;
		}
		return res;
	}
	private static int[] maxSub(int[] nums, int k){
		if(k == 0 || nums == null)
			return null;
		int[] res = new int[k];
		int size = 0;
		for(int i = 0; i<nums.length; i++){
			while(size >0 && size+nums.length-i>k && nums[i]>res[size-1])
				size--;
			if(size < k)
				res[size++] = nums[i];
		}
		return res;
	}
	private static int compare(int[] sub1, int s1, int[] sub2, int s2){
		if(sub1 == null || s1>=sub1.length)
			return -1;
		if(sub2 == null || s2>=sub2.length)
			return 1;
		while(s1 < sub1.length && s2 < sub2.length){
			if(sub1[s1] == sub2[s2]){
				s1++; s2++;
			}else
				return sub1[s1] - sub2[s2];
		}
		return sub1.length-sub2.length;
	}
	private static int[] merge(int[] sub1, int[] sub2){
		if(sub1 == null)
			return sub2;
		if(sub2 == null)
			return sub1;
		int s1 = 0, s2 = 0;
		int res[] = new int[sub1.length+sub2.length];
		int i = 0;
		while(s1<sub1.length || s2<sub2.length){
			res[i++] = (compare(sub1,s1,sub2,s2)<0)?sub2[s2++]:sub1[s1++];
		}
		return res;
	}
	public static void main(String[] args) {
		int[] nums1 = {5,0,2,1,0,1,0,3,9,1,2,8,0,9,8,1,4,7,3};
		int[] nums2 = {7,6,7,1,0,1,0,5,6,0,5,0};
		int k = 31;
		int[] res = maxNumber(nums1,nums2,k);
		System.out.format("max number is %s\n",Arrays.toString(res));
	}
}