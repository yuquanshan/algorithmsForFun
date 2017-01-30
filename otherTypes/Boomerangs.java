/** Given n points in the plane that are all pairwise distinct, a "boomerang" 
* is a tuple of points (i, j, k) such that the distance between i and j equals 
* the distance between i and k (the order of the tuple matters).
*
* Find the number of boomerangs. You may assume that n will be at most 500 and 
* coordinates of points are all in the range [-10000, 10000] (inclusive).
*
* Example:
* Input:
* [[0,0],[1,0],[2,0]]
* Output:
* 2
* Explanation:
* The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
* public int numberOfBoomerangs(int[][] points)
*/
import java.util.*;

public class Boomerangs{
	public static int numberOfBoomerangs(int[][] points){
		
		int count = 0;
		for(int[] p: points){
			HashMap<Integer, Integer> l2n = new HashMap<Integer, Integer>();// leg len -> # of legs map
			for(int[] l: points){
				int d = getDistance(p,l);
				int tmp = 0;
				if(l2n.containsKey(d))
					tmp = l2n.get(d);
				l2n.put(d,tmp+1);
			}
			for(int key: l2n.keySet()){
				count += l2n.get(key)*(l2n.get(key)-1);
			}
		}
		return count;
	}
	private static int getDistance(int[] a, int[] b){
		return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
	}
	public static void main(String[] args) {
		int[][] points = {{0,0},{1,0},{2,0}};
		System.out.println(numberOfBoomerangs(points));
	}
}
