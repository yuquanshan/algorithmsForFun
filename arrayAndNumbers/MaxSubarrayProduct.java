/**
given an array, return the largest subarray product.
public static int maxProd(int[] nums)
(unable to finish on time in the first time)
*/
import java.util.*;
public class MaxSubarrayProduct{
	public static int maxProd(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		int maxSoFar = nums[0];
		int[] arrayPos = new int[nums.length];
		int[] arrayNeg = new int[nums.length];
		arrayPos[0] = Math.max(0,nums[0]);
		arrayNeg[0] = Math.min(0,nums[0]);
		for(int i = 1; i < nums.length; i++){
			if(nums[i] > 0){
				arrayPos[i] = Math.max(arrayPos[i-1]*nums[i],nums[i]);
				arrayNeg[i] = Math.min(arrayNeg[i-1]*nums[i],0);
			}else if(nums[i]<0){
				arrayPos[i] = Math.max(0,arrayNeg[i-1]*nums[i]);
				arrayNeg[i] = Math.min(nums[i],arrayPos[i-1]*nums[i]);
			}else{
				arrayPos[i] = 0;
				arrayNeg[i] = 0;
			}
			if(arrayPos[i]>maxSoFar)
				maxSoFar = arrayPos[i];
		}
		return maxSoFar;
	}
	public static void main(String[] args) {
		int[] nums = {-3,-1,3,5,-6,-6,-1,6,-3,-5,1,0,-6,-5,0,-2,6,1,0,5};
		System.out.format("The max subarray product of %s is %d.\n",Arrays.toString(nums),maxProd(nums));
	}
}