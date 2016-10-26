/**
* given an unsorted array of integers, find the length of longest consecutive sequence 
* ignoring the order of array, e.g., given [100,4,200,1,3,2], return 4 (for [1,2,3,4])
* public static int longestConsecutive(int[] num)
*/
import java.util.*;

public class LongestConsecutiveSequence{
	public static int longestConsecutive(int[] num){
		if(num == null)
			return 0;
		if(num.length <= 1)
			return num.length;
		HashSet<Integer> totalset = new HashSet<Integer>();	// set containing all the elements
		HashSet<Integer> glueset = new HashSet<Integer>();	// set recording the visited elements and elements with "glue stain"
		for(int i: num)
			totalset.add(i);
		int maxLen = 0;
		for(int i: totalset){
			if(!glueset.contains(i)){
				glueset.add(i);
				int tmpLen = 1;
				int flag = 1;
				int left = i;
				int right = i;
				while(flag == 1){
					flag = 0;
					if(totalset.contains(left-1)){
						glueset.add(left-1);
						left--;
						flag = 1;
						tmpLen++;
					}
					if(totalset.contains(right+1)){
						glueset.add(right+1);
						right++;
						flag = 1;
						tmpLen++;
					}
				}
				maxLen = (tmpLen>maxLen)?tmpLen:maxLen;
			}
		}
		return maxLen;
	}
	public static void main(String[] args) {
		int[] num = {100,4,200,1,3,2};
		System.out.format("The max seq len of %s is %d.\n", Arrays.toString(num),longestConsecutive(num));
	}
}