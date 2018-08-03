/** Perfect Rectangle
* Given N axis-aligned rectangles where N > 0, determine if they all 
* together form an exact cover of a rectangular region.
*
* Each rectangle is represented as a bottom-left point and a top-right point. 
* For example, a unit square is represented as [1,1,2,2]. (coordinate of 
* bottom-left point is (1, 1) and top-right point is (2, 2)).
*
* rectangles = [
*  [1,1,3,3],
*  [3,1,4,2],
*  [3,2,4,4],
*  [1,3,2,4],
*  [2,3,3,4]
* ]
*
* Return true. All 5 rectangles together form an exact cover of a rectangular region.
* public boolean isRectangleCover(int[][] rectangles)
* (tried to solve in O(n^2) in my first try, but TLE, there are O(nlogn) and O(n) 
* algorithms, both are acceptable...)
*/
import java.util.*;

public class PerfectRectangle{
	public static boolean isRectangleCover(int[][] rectangles){
		HashSet<String> set = new HashSet<String>(); // a proof can be seen here https://discuss.leetcode.com/topic/56052/really-easy-understanding-solution-o-n-java/12
		int leftest = Integer.MAX_VALUE, rightest = Integer.MIN_VALUE, topest = Integer.MAX_VALUE, bottomest = Integer.MIN_VALUE;
		int area = 0;
		for(int[] rec: rectangles){
			leftest = Math.min(leftest, rec[0]);
			topest = Math.min(topest, rec[1]);
			rightest = Math.max(rightest, rec[2]);
			bottomest = Math.max(bottomest, rec[3]);
			String lt = Integer.toString(rec[0])+" "+Integer.toString(rec[1]);
			String rt = Integer.toString(rec[2])+" "+Integer.toString(rec[1]);
			String lb = Integer.toString(rec[0])+" "+Integer.toString(rec[3]);
			String rb = Integer.toString(rec[2])+" "+Integer.toString(rec[3]);
			if(!set.add(lt)) set.remove(lt);
			if(!set.add(rt)) set.remove(rt);
			if(!set.add(lb)) set.remove(lb);
			if(!set.add(rb)) set.remove(rb);
			area += (rec[2]-rec[0])*(rec[3]-rec[1]);
		}
		if(set.size() == 4 && set.contains(Integer.toString(leftest)+" "+Integer.toString(bottomest)) && set.contains(Integer.toString(rightest)+" "+Integer.toString(bottomest)) &&
			set.contains(Integer.toString(rightest)+" "+Integer.toString(topest)) && set.contains(Integer.toString(leftest)+" "+Integer.toString(topest)) && area == (rightest-leftest)*(bottomest-topest))
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		int[][] rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
		if(isRectangleCover(rectangles))
			System.out.println("Good!");
		else
			System.out.println("Oops!");
	}
}