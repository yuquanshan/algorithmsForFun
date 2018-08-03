/**
* given an array, find all unique triplets that sum to zero.
* public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers, int target)
* (wrote a dumb Hashtable algorithm in the first time)
*/

import java.util.*;

public class ThreeSum{
	public static ArrayList<ArrayList<Integer>> threeSum(int[] numbers){
		if(numbers==null || numbers.length < 3)
			return null;
		Arrays.sort(numbers);
		int start = 0;
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		while(start < numbers.length-2){
			int left = start + 1;
			int right = numbers.length-1;
			while(left < right){
				if(numbers[left]+numbers[right]+numbers[start]==0){
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(numbers[start]);
					list.add(numbers[left]);
					list.add(numbers[right]);
					res.add(list);
					int tmp = numbers[right];
					while(right > left && numbers[right]==tmp)
						right--;
				}else if(numbers[left]+numbers[right]+numbers[start]<0){
					int tmp = numbers[left];
					while(left < right && numbers[left]==tmp)
						left++;
				}else{
					int tmp = numbers[right];
					while(right > left && numbers[right]==tmp)
						right--;
				}
			}
			int tmp = numbers[start];
			while(start < numbers.length-2 && numbers[start]==tmp)
				start++;
		}
		return res;
	}
	public static void main(String[] args) {
		int[] numbers = {-1,0,1,2,-1,-4};
		ArrayList<ArrayList<Integer>> res = threeSum(numbers);
		for(ArrayList<Integer> l: res){
			System.out.println(l.toString());
		}
	}
}