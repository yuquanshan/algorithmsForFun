/** Given an array of meeting time intervals consisting of start and end times 
* [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
* For example,
* Given [[0, 30],[5, 10],[15, 20]],
* return 2.
* public class Interval {
*     int start;
*     int end;
*     Interval() { start = 0; end = 0; }
*     Interval(int s, int e) { start = s; end = e; }
* }
* public int minMeetingRooms(Interval[] intervals)
*/

import java.util.*;

public class MeetingRooms{
	static class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	public static int minMeetingRooms(Interval[] intervals){
		if(intervals == null || intervals.length == 0)
			return 0;
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval i1, Interval i2){
				return i1.start - i2.start;
			}
		});
		int rooms = 1;
		for(Interval i: intervals){
			while(!heap.isEmpty() && heap.peek()<=i.start)
				heap.poll();
			heap.add(i.end);
			rooms = Math.max(rooms, heap.size());
		}
		return rooms;
	}
	public static void main(String[] args) {
		Interval[] intervals = {new Interval(0,30), new Interval(5,10), new Interval(15,20)};
		System.out.println(minMeetingRooms(intervals));
	}
}