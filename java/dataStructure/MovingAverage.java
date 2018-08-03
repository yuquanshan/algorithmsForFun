/**
* write a moving average sliding window for a data stream 
*	public class MovingAverage {
*	    public MovingAverage(int size){}
*	    public double next(int val){}	// add new data to the window
*	} 
*/
import java.util.*;

public class MovingAverage{
	double avg;
	int size;
	Queue<Integer> queue;
    public MovingAverage(int size){
    	avg = 0;
    	this.size = size;
    	queue = new LinkedList<Integer>();
    }
    public double next(int val){
    	if(queue.size() < size){
    		avg = (double)queue.size()/(queue.size()+1)*avg+((double)val)/(queue.size()+1);
    		queue.add(val);
    		return avg;
    	}else{
    		double old = queue.poll();
    		avg = avg+(val-old)/size;
    		queue.add(val);
    		return avg;
    	}
    }
    public static void main(String[] args) {
    	int size = 3;
    	int[] stream = {1,10,3,5};
    	MovingAverage ma = new MovingAverage(size);
    	for(int i: stream){
    		System.out.println(ma.next(i));
    	}
    }
} 