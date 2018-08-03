/**
* given two arrays, get the intersection elements, e.g.,
* given [1,2,2,1] and [2,2], should return [2].
* public static int[] intersection(int[] nums1, int[] nums2).
*/
import java.util.*;

public class TwoArrayIntersection{
	public static int[] intersection(int[] nums1, int[] nums2){
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return new int[0];
		ArrayList<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> alreadyset = new HashSet<Integer>();
		for(int i = 0; i<nums1.length; i++){
			set.add(nums1[i]);
		}
		for(int i = 0; i<nums2.length; i++){
			if(set.contains(nums2[i]) && !(alreadyset.contains(nums2[i]))){
				alreadyset.add(nums2[i]);
				list.add(nums2[i]);
			}
		}
		int[] res = new int[list.size()];
		for(int i = 0; i<list.size(); i++)
			res[i] = list.get(i);
		return res;
	}
	public static void main(String[] args) {
		int[] n1 = {1,2,2,1};
		int[] n2 = {2,2};
		int[] n3 = intersection(n1,n2);
		System.out.format("Two arrays are: %s, %s\n",Arrays.toString(n1),Arrays.toString(n2));
		System.out.println("Their intersection is:");
		System.out.println(Arrays.toString(n3));
	}
}