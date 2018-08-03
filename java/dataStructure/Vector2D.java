/** Implement an iterator to flatten a 2d vector.
* For example,
* Given 2d vector =
* [
*  [1,2],
*  [3],
*  [4,5,6]
* ]
* By calling next repeatedly until hasNext returns false, 
* the order of elements returned by next should be: [1,2,3,4,5,6].
*
* public class Vector2D implements Iterator<Integer> {
*    public Vector2D(List<List<Integer>> vec2d) {}
*    @Override
*    public Integer next() {}
*    @Override
*    public boolean hasNext(){}
* }
*/
import java.util.*;

public class Vector2D implements Iterator<Integer> {
	LinkedList<List<Integer>> workinglist; 
	int pt;
    public Vector2D(List<List<Integer>> vec2d) {
        workinglist = new LinkedList<List<Integer>>();
        for(List<Integer> l: vec2d){
        	workinglist.add(l);
        }
        pt = 0;
        while(!workinglist.isEmpty() && pt >= workinglist.peekFirst().size()){
        	workinglist.removeFirst();
        }
    }

    @Override
    public Integer next() {
        if(hasNext()){
        	int res = workinglist.peekFirst().get(pt);
        	pt++;
        	while(!workinglist.isEmpty() && pt >= workinglist.peekFirst().size()){
        		workinglist.removeFirst();
        		pt = 0;
        	}
        	return res;
        }else{
        	return -1;
        }
    }

    @Override
    public boolean hasNext() {
        return !workinglist.isEmpty();
    }
    public static void main(String[] args) {
    	List<List<Integer>> vec2d = new ArrayList<List<Integer>>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	tmp.add(1); tmp.add(2);
    	vec2d.add(tmp);
    	tmp = new ArrayList<Integer>();
    	tmp.add(3);
    	vec2d.add(tmp);
    	tmp = new ArrayList<Integer>();
    	tmp.add(4); tmp.add(5); tmp.add(6);
    	vec2d.add(tmp);
    	Vector2D iter = new Vector2D(vec2d);
    	while(iter.hasNext())
    		System.out.println(iter.next());
    }
}