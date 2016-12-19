/**
* given a list of intervals which are defined as 
* 	public class Interval {
*     	int start, end;
*     	Interval(int start, int end) {
*         	this.start = start;
*         	this.end = end;
*     	}
*	}
* merge all overlapping intervals, for example
* [                     [
*  [1, 3],               [1, 6],
*  [2, 6],      =>       [8, 10],
*  [8, 10],              [15, 18]
*  [15, 18]             ]
* ]
* public static List<Interval> merge(List<Interval> intervals)
*/
import java.util.*;

public class MergeIntervals{
	static class Interval{
		int start, end;
		Interval(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
	public static List<Interval> merge(List<Interval> intervals) {
        if(intervals == null)
        	return null;
        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval a, Interval b){
        		return a.start - b.start;
        	}
        });
        ArrayList<Interval> res = new ArrayList<Interval>();
        for(Interval inter: intervals){
        	if(res.size() == 0 || res.get(res.size()-1).end < inter.start)
        		res.add(inter);
        	else{
        		res.get(res.size()-1).end = Math.max(res.get(res.size()-1).end,inter.end);
        	}
        }
        return res;
    }
    public static void main(String[] args) {
    	List<Interval> intervals = new ArrayList<Interval>();
    	intervals.add(new Interval(1,3));
    	intervals.add(new Interval(2,6));
    	intervals.add(new Interval(8,10));
    	intervals.add(new Interval(15,18));
    	List<Interval> res = merge(intervals);
    	System.out.println("Merge result is ");
    	for(Interval i: res){
    		System.out.format("[%d,%d]\n",i.start,i.end);
    	}
    }
}