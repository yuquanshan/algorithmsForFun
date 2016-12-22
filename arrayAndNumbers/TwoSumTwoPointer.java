/**
* try to use double pointer to solve two sum problem,
* given an array find two numbers such that they add 
* up to a specific target number.
* public static int[] twoSum(int[] numbers, int target)
*/
import java.util.*;

public class TwoSumTwoPointer{
	public static int[] twoSum(int[] numbers, int target){
		if(numbers == null || numbers.length < 2)
			return null;
		int[] map = new int[numbers.length];
		for(int i = 0; i < numbers.length; i++){
			map[i] = i+1;
		}
		quicksort(numbers,map, 0, numbers.length-1);
		System.out.println(Arrays.toString(numbers));
		System.out.println(Arrays.toString(map));
		int start = 0;
		int end = numbers.length-1;
		while(start != end){
			if(numbers[start]+numbers[end]==target){
				int[] res = {map[start],map[end]};
				return res;
			}else if(numbers[start]+numbers[end]>target){
				end--;
			}else{
				start++;
			}
		}
		return null;
	}
	public static void quicksort(int[] numbers, int[] map, int start, int end){
		if(start<end){
			int num = numbers[end];
			int pt = start;
			for(int i = start; i<end; i++){
				if(numbers[i] <= num){
					int tmp = numbers[pt];
					int tmp1 = map[pt];
					numbers[pt] = numbers[i];
					map[pt] = map[i];
					numbers[i] = tmp;
					map[i] = tmp1;
					pt++;
				}
			}
			int tmp = numbers[pt];
			int tmp1 = map[pt];
			numbers[end] = tmp;
			map[pt] = map[end];
			map[end] = tmp1;
			numbers[pt] = num;
			quicksort(numbers,map,start,pt-1);
			quicksort(numbers,map,pt+1,end);
		}
	}
	public static void main(String[] args) {
		int[] numbers = {2, 7, 11, 15};
		int target = 9;
		int[] res = twoSum(numbers,target);
		System.out.format("%d,%d\n",res[0],res[1]);
	}
}