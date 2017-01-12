/** Given a list of points that form a polygon when joined sequentially, 
* find if this polygon is convex (Convex polygon definition).
*
* Note:
* There are at least 3 and at most 10,000 points.
* Coordinates are in the range -10,000 to 10,000.
* You may assume the polygon formed by given points is always a simple polygon 
* (Simple polygon definition). In other words, we ensure that exactly two edges 
* intersect at each vertex, and that edges otherwise don't intersect each other.
* public boolean isConvex(List<List<Integer>> points)
* (can use cross product to solve this problem in O(n))
*/
import java.util.*;

public class ConvexPolygon{
	public static boolean isConvex(List<List<Integer>> points){
		for(int i = 0; i<points.size()-1; i++){
			if(!oneHalfPlane(points,points.get(i).get(0), points.get(i).get(1), points.get(i+1).get(0), points.get(i+1).get(1)))
				return false;
		}
		return oneHalfPlane(points, points.get(0).get(0),points.get(0).get(1),points.get(points.size()-1).get(0),points.get(points.size()-1).get(1));
	}
	private static boolean oneHalfPlane(List<List<Integer>> points, int x1, int y1, int x2, int y2){
		float standard = 0;
		if(x1 == x2){
			for(List<Integer> point: points){
				int tmp = x1 - point.get(0);
				if(tmp != 0 && standard == 0)
					standard = tmp;
				if(tmp*standard<0)
					return false;
			}
		}else{
			for(List<Integer> point: points){
				float tmp = (float)point.get(1) - (float)y1 - (float)(y2-y1)/(float)(x2-x1)*(point.get(0)-x1);
				if(tmp != 0 && standard == 0)
					standard = tmp;
				if(tmp*standard<0)
					return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		List<List<Integer>> points = new ArrayList<List<Integer>>();
		List<Integer> point = new ArrayList<Integer>();
		point.add(0); point.add(0); points.add(point);
		point = new ArrayList<Integer>();
		point.add(0); point.add(10); points.add(point);
		point = new ArrayList<Integer>();
		point.add(10); point.add(10); points.add(point);
		point = new ArrayList<Integer>();
		point.add(10); point.add(0); points.add(point);
		point = new ArrayList<Integer>();
		point.add(5); point.add(5); points.add(point);
		System.out.println(isConvex(points));
	}
}