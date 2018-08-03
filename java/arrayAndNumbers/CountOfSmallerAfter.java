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
		if(nums == null || nums.length == 0){
			return res;
		}
		int[][] info = new int[nums.length][3];	// value/pos/count
		for(int i = 0; i<nums.length; i++){
			info[i][0] = nums[i];
			info[i][1] = i;
			info[i][2] = 0;
		}
		msort(info, 0, info.length-1);
		int[] tmp = new int[nums.length];
		for(int[] i: info){
			tmp[i[1]] = i[2];
		}
		for(int j: tmp)
			res.add(j);
		return res;
	}
	private static void msort(int[][] info, int start, int end){
		if(start != end){
			int mid = start+(end-start)/2;
			msort(info, start, mid);
			msort(info, mid+1, end);
			int rightmoved = 0;
			int[][] buffer = new int[end-start+1][3];
			int s1 = start, s2 = mid+1;
			for(int i = 0; i<end-start+1; i++){
				if(s1 > mid){
					buffer[i] = info[s2++];
					rightmoved++;
				}else if(s2 > end){
					info[s1][2] += rightmoved;
					buffer[i] = info[s1++];
				}else if(info[s1][0]<=info[s2][0]){
					info[s1][2] += rightmoved;
					buffer[i] = info[s1++];
				}else{
					buffer[i] = info[s2++];
					rightmoved++;
				}
			}
			for(int i = start; i<=end; i++)
				info[i] = buffer[i-start];
		}
	}
	public static void main(String[] args) {
		int[] nums = {5,2,6,1};
		List<Integer> res = countSmaller(nums);
		System.out.println(res.toString());
	}
}