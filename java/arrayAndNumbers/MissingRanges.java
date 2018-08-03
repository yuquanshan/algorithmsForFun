/**
* given a sorted integer array, find its missing ranges,
* for example, given [0,1,3,50,75], lower = 0, upper = 99, 
* return ["2", "4->49", "51->74", "76->99"]. 
* public static List<String> findMissingRanges(int[] nums, int lower, int upper){}
*/
import java.util.*;

public class MissingRanges{
	public static List<String> findMissingRanges(int[] nums, int lower, int upper){
		ArrayList<String> res = new ArrayList<String>();
		if(nums == null || nums.length == 0){
			String tmp = (lower!=upper)?Integer.toString(lower)+"->"+Integer.toString(upper):Integer.toString(lower);
			res.add(tmp);
			return res;
		}
		int pt = 0;
		for(int i = 1; i<nums.length; i++){
			if(nums[pt] != nums[i])
				nums[++pt] = nums[i];
		}
		nums = Arrays.copyOfRange(nums,0,pt+1);
		if(lower < nums[0]){
			if(lower == nums[0]-1){
				res.add(Integer.toString(lower));
			}else if(lower < nums[0]-1){
				res.add(Integer.toString(lower)+"->"+Integer.toString(nums[0]-1));
			}
		}
		for(int i = 0; i<nums.length-1; i++){
			if(nums[i]+2 == nums[i+1])
				res.add(Integer.toString(nums[i]+1));
			else if(nums[i]+2 < nums[i+1])
				res.add(Integer.toString(nums[i]+1)+"->"+Integer.toString(nums[i+1]-1));
		}
		if(upper > nums[nums.length-1]){
			if(upper == nums[nums.length-1]+1)
				res.add(Integer.toString(upper));
			else if(upper > nums[nums.length-1]+1)
				res.add(Integer.toString(nums[nums.length-1]+1)+"->"+Integer.toString(upper));
		}
		return res;
	}
	public static void main(String[] args) {
		//int[] nums = {0,1,3,50,75};
		int[] nums = {};
		int lower = 0;
		int upper = 99;
		System.out.println(findMissingRanges(nums,lower,upper).toString());
	}
}