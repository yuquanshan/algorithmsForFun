/**
* given two arrays, return a iterator which alternatively
* visited the elements of this two arrays.
*	public class ZigzagIterator {
*    	public ZigzagIterator(List<Integer> v1, List<Integer> v2){}
*    	public int next(){}
*    	public boolean hasNext(){}
*	}
*/
import java.util.*;

public class ZigzagIterator {
	private LinkedList<Integer> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2){
    	queue = new LinkedList<Integer>();
    	boolean stop = false;
    	while(!stop){
    		stop = true;
    		if(v1.size()!=0){
    			stop = false;
    			queue.add(v1.remove(0));
    		}
    		if(v2.size()!=0){
    			stop = false;
    			queue.add(v2.remove(0));
    		}
    	}
    }
    public int next(){
    	if(hasNext())
    		return queue.poll();
    	else
    		return -1;
    }
    public boolean hasNext(){
    	return !queue.isEmpty();
    }
}