/**
* Given a sorted array of integers nums and integer values a, b and c. 
* Apply a function of the form f(x) = ax^2 + bx + c to each element x 
* in the array.
*
* The returned array must be in sorted order. Expected time complexity: O(n)
*
* Example:
* nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
* Result: [3, 9, 15, 33]
* nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
* Result: [-23, -5, 1, 7]
* public int[] sortTransformedArray(int[] nums, int a, int b, int c)
*/
import java.util.*;

public class SortTransformedArray{
	public static int[] sortTransformedArray(int[] nums, int a, int b, int c){
		if(nums == null || nums.length == 0)
			return nums;
		int[] res = new int[nums.length];
		if(a == 0){
			if(b>=0){
				for(int i = 0; i<nums.length; i++)
					res[i] = func(a, b, c, nums[i]);
			}else{
				for(int i = 0; i<nums.length; i++)
					res[nums.length-1-i] = func(a, b, c, nums[i]);
			}
		}else if(a > 0){
			float t = -b/(2*a);
			int start = 0;
			int end = nums.length-1;
			while(end - start > 1){
				int mid = start+(end-start)/2;
				if((float)nums[mid] == t){
					start = mid;
					break;
				}else if((float)nums[mid] > t){
					end = mid;
				}else{
					start = mid;
				}
			}
			int left = 0, right = 0;
			if(func(a,b,c,nums[start]) <= func(a,b,c,nums[end])){
				left = start-1; right = start+1;
				res[0] = func(a,b,c,nums[start]);
			}else{
				left = end-1; right = end+1;
				res[0] = func(a,b,c,nums[end]);
			}
			int i = 1;
  			while(left>=0 || right < nums.length){
  				if(left < 0){
  					res[i++] = func(a,b,c,nums[right++]);
  				}else if(right >= nums.length){
  					res[i++] = func(a,b,c, nums[left--]);
  				}else if(func(a,b,c,nums[left])<=func(a,b,c,nums[right])){
  					res[i++] = func(a,b,c,nums[left--]);
  				}else{
  					res[i++] = func(a,b,c,nums[right++]);
  				}
  			}
		}else{
			float t = -b/(2*a);
			int start = 0;
			int end = nums.length-1;
			while(end - start > 1){
				int mid = start+(end-start)/2;
				if((float)nums[mid] == t){
					start = mid;
					break;
				}else if((float)nums[mid] > t){
					end = mid;
				}else{
					start = mid;
				}
			}
			int left = 0, right = 0;
			if(func(a,b,c,nums[start]) <= func(a,b,c,nums[end])){
				left = end-1; right = end+1;
				res[nums.length-1] = func(a,b,c,nums[end]);
			}else{
				left = start-1; right = start+1;
				res[nums.length-1] = func(a,b,c,nums[start]);
			}
			int i = nums.length-2;
			while(left>=0 || right < nums.length){
  				if(left < 0){
  					res[i--] = func(a,b,c,nums[right++]);
  				}else if(right >= nums.length){
  					res[i--] = func(a,b,c, nums[left--]);
  				}else if(func(a,b,c,nums[left])<=func(a,b,c,nums[right])){
  					res[i--] = func(a,b,c,nums[right++]);
  				}else{
  					res[i--] = func(a,b,c,nums[left--]);
  				}
  			}
		}
		return res;
	}
	private static int func(int a, int b, int c, int x){
		return a*x*x+b*x+c;
	}
	public static void main(String[] args) {
		int[] nums = {-4, -2, 2, 4};
		int a = 1, b = 3, c = 5;
		int[] res = sortTransformedArray(nums, a, b, c);
		System.out.println(Arrays.toString(res));
		a = -1; b = 3; c = 5;
		res = sortTransformedArray(nums, a, b, c);
		System.out.println(Arrays.toString(res));
	}
}