/* Given a collection of intervals, merge all overlapping intervals.
* For example,
* Given [1,3],[2,6],[8,10],[15,18],
* return [1,6],[8,10],[15,18].
*	public class Interval {
*     	int start;
*     	int end;
*     	Interval() { start = 0; end = 0; }
*     	Interval(int s, int e) { start = s; end = e; }
* 	}
* public List<Interval> merge(List<Interval> intervals)
*/
import java.util.*;

public class MergeIntervals{
	static class Interval {
     	int start;
     	int end;
     	Interval() { start = 0; end = 0; }
     	Interval(int s, int e) { start = s; end = e; }
	}
	public static List<Interval> merge(List<Interval> intervals){
		if(intervals == null || intervals.size() == 0){
			return new ArrayList<Interval>();
		}
		ArrayList<Interval> res = new ArrayList<Interval>();
		Collections.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		});
		for(Interval i: intervals){
			if(res.size() == 0 || res.get(res.size()-1).end < i.start){
				res.add(i);
			}else{
				res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end,i.end);
			}
		}
		return res;
	}
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3)); intervals.add(new Interval(2,6)); 
		intervals.add(new Interval(8,10)); intervals.add(15,18);
		List<Interval> res = merge(intervals);
		for(Interval r: res)
			System.out.format("[%d,%d] ", r.start, r.end);
		System.out.println();
	}
}