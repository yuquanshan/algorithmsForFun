/** Given a set of non-overlapping intervals, insert a new 
* interval into the intervals (merge if necessary).
*
* You may assume that the intervals were initially sorted according to their start times.
*
* Example 1:
* Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
* 
* Example 2:
* Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
* 
* This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
* 	public class Interval {
*     	int start;
*     	int end;
*     	Interval() { start = 0; end = 0; }
*     	Interval(int s, int e) { start = s; end = e; }
* 	}
* public List<Interval> insert(List<Interval> intervals, Interval newInterval)
*/
import java.util.*;

public class InsertInterval{
	static class Interval {
     	int start;
     	int end;
     	Interval() { start = 0; end = 0; }
     	Interval(int s, int e) { start = s; end = e; }
 	}
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval){
		int size = intervals.size();
		int start = 0, end = size-1;
		int t = -1;
		if(size > 0){
			while(end - start > 1){
				int mid = start+(end-start)/2;
				if(intervals.get(mid).start == newInterval.start){
					start = mid; end = mid;
					break;
				}else if(intervals.get(mid).start > newInterval.start){
					end = mid;
				}else{
					start = mid;
				}
			}
			if(intervals.get(start).start > newInterval.start)
				t = start-1;
			else if(intervals.get(end).start <= newInterval.start)
				t = end;
			else if(intervals.get(start).start <= newInterval.start)
				t = start;
		}
		intervals.add(t+1,newInterval);
		//merge interval
		List<Interval> res = new ArrayList<Interval>();
		Interval tmp = null;
		for(Interval it: intervals){
			if(res.size()==0){
				res.add(it);
				tmp = it;
			}else{
				if(tmp.end < it.start){
					res.add(it);
					tmp = it;
				}else{
					tmp.end = Math.max(tmp.end, it.end);
				}
			}
		}
		return res;
	}
	public static void main(String[] args) {
		//[1,2],[3,5],[6,7],[8,10],[12,16]
		List<Interval> intervals = new ArrayList<Interval>();
		//intervals.add(new Interval(1,2)); intervals.add(new Interval(3,5));
		//intervals.add(new Interval(6,7)); intervals.add(new Interval(8,10));
		//intervals.add(new Interval(12,16));
		intervals.add(new Interval(2,6)); intervals.add(new Interval(7,9));
		List<Interval> res = insert(intervals,new Interval(15,18));
		for(Interval i: res){
			System.out.format("[%d, %d] ",i.start, i.end);
		}
		System.out.println();
	}
}

