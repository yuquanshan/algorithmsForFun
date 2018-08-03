/** Design a hit counter which counts the number of hits received in the past 5 minutes.
* Each function accepts a timestamp parameter (in seconds granularity) and you may assume 
* that calls are being made to the system in chronological order (ie, the timestamp is 
* monotonically increasing). You may assume that the earliest timestamp starts at 1.
* 
* It is possible that several hits arrive roughly at the same time.
* 
* Example:
* HitCounter counter = new HitCounter();
* // hit at timestamp 1.
* counter.hit(1);
* // hit at timestamp 2.
* counter.hit(2);
* // hit at timestamp 3.
* counter.hit(3);
* // get hits at timestamp 4, should return 3.
* counter.getHits(4);
* // hit at timestamp 300.
* counter.hit(300);
* // get hits at timestamp 300, should return 4.
* counter.getHits(300);
* // get hits at timestamp 301, should return 3.
* counter.getHits(301); 
* Follow up:
* What if the number of hits per second could be very large? Does your design scale?
*	public class HitCounter() {
*    	public void hit(int timestamp) {}
*    	public int getHits(int timestamp) {}
*   }
*/
import java.util.*;

public class HitCounter{
	int count;
	int cur;
	Queue<Integer> queue;
	HashMap<Integer, Integer> map;	// how many hits on a timestamp - a key
	HitCounter(){
		count = 0;
		cur = 0;
		queue = new LinkedList<Integer>();
		map = new HashMap<Integer,Integer>();
	}
	public void hit(int timestamp){
		cur = timestamp;
		if(!map.containsKey(cur)){
			map.put(cur,1);
			queue.add(timestamp);
		}else{
			map.put(cur,map.get(cur)+1);
		}
		count++;
		while(!queue.isEmpty() && queue.peek()<=timestamp-300){
			int ts = queue.remove();
			count-=map.remove(ts);
		}
	}
 	public int getHits(int timestamp){
 		cur = timestamp;
 		while(!queue.isEmpty() && queue.peek()<=timestamp-300){
			int ts = queue.remove();
			count-=map.remove(ts);
		}
		return count;
 	}
 	public static void main(String[] args) {
 		HitCounter counter = new HitCounter();
		// hit at timestamp 1.
		counter.hit(1);
		// hit at timestamp 2.
		counter.hit(2);
		// hit at timestamp 3.
		counter.hit(3);
		// get hits at timestamp 4, should return 3.
		counter.getHits(4);
		// hit at timestamp 300.
		counter.hit(300);
		// get hits at timestamp 300, should return 4.
		System.out.println(counter.getHits(300));
		// get hits at timestamp 301, should return 3.
		System.out.println(counter.getHits(301)); 
 	}
}