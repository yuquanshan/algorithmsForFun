/** Assume you have an array of length n initialized with 
* all 0's and are given k update operations.
*
*Each operation is represented as a triplet: [startIndex, endIndex, inc] 
* which increments each element of subarray A[startIndex ... endIndex] 
* (startIndex and endIndex inclusive) with inc.
*
* Return the modified array after all k operations were executed.
*
* Example:
* 
* Given:
*    length = 5,
*    updates = [
*        [1,  3,  2],
*        [2,  4,  3],
*        [0,  2, -2]
*    ]
* Output:
*    [-2, 0, 3, 5, 3]
* Explanation:
* Initial state:
* [ 0, 0, 0, 0, 0 ]
*
* After applying operation [1, 3, 2]:
* [ 0, 2, 2, 2, 0 ]
* 
* After applying operation [2, 4, 3]:
* [ 0, 2, 5, 5, 3 ]
*
* After applying operation [0, 2, -2]:
* [-2, 0, 3, 5, 3 ]
* public int[] getModifiedArray(int length, int[][] updates)
* (Event+heap is just overkill...)
*/
import java.util.*;

public class RangeAddition{
	static class Event{
		int time;
		int change;
		Event(int time, int change){
			this.time = time;
			this.change = change;
		}
	}
	public static int[] getModifiedArray(int length, int[][] updates){
		PriorityQueue<Event> heap = new PriorityQueue<Event>(new Comparator<Event>(){
			public int compare(Event e1, Event e2){
				return e1.time - e2.time;
			}
		});
		for(int[] update: updates){
			heap.add(new Event(update[0],update[2]));
			heap.add(new Event(update[1]+1,-update[2]));
		}
		int[] res = new int[length];
		int acc = 0;
		for(int i = 0; i<length; i++){
			while(!heap.isEmpty() && heap.peek().time==i){
				acc += heap.poll().change;
			}
			res[i] = acc;
		}
		return res;
	}
	public static void main(String[] args) {
		int length = 5;
		int[][] updates = {{1, 3, 2},{2, 4, 3},{0, 2, -2}};
		System.out.println(Arrays.toString(getModifiedArray(length,updates)));
	}
}