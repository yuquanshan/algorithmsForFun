/**
* given an list of intervals [start,end) which indicate the time
* range of planes on the sky, return the max number of planes on 
* the sky.
* public class Interval {
*     int start, end;
*     Interval(int start, int end) {
*         this.start = start;
*         this.end = end;
*     }
* }
* public static int countOfAirplanes(List<Interval> airplanes)
* (initially given a naive algorithm which passes the test, didn't 
* notice that there is a more elegant solution)
*/

import java.util.*;

class Interval {
	int start, end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class NumberOfPlanesOnTheSky{
	static class EventTS{	// event time stamp	
		int time;	// time stamp
		int flag;	// type of event, 1 for take off, 0 for landing
		EventTS(int time, int flag){
			this.time = time;
			this.flag = flag;
		}
	}
	public static int countOfAirplaines(List<Interval> airplanes){
		EventTS[] times = new EventTS[airplanes.size()*2];
		int count = 0;
		for(Interval i: airplanes){
			times[2*count] = new EventTS(i.start,1);
			times[2*count+1] = new EventTS(i.end,0);
			count++;
		}	
		Arrays.sort(times,new Comparator<EventTS>(){
			public int compare(EventTS e1, EventTS e2){
				if(e1.time == e2.time){
					return e1.flag - e2.flag;
				}else{
					return e1.time - e2.time;
				}
			}
		});
		count = 0;
		for(int i = 0; i<times.length; i++){
			if(times[i].flag == 1)
				count++;
			else
				count--;
		}
		return count;
	}
}