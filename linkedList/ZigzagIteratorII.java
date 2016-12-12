/**
* given a list of lists of integers, write an iterator which 
* alteratively visit the elements of those lists.
*	public class ZigzagIteratorII {
*  		public ZigzagIteratorII(ArrayList<ArrayList<Integer>> vecs){}
*    	public int next(){}
*    	public boolean hasNext(){}
*	}
* (there are many possible ways to implement but pay attention to the time limit
* exceeded time limit in my first try, a Google interview problem)
*/
import java.util.*;

public class ZigzagIteratorII {
	static class LLNode{
		ArrayList<Integer> content;
		LLNode next;
		LLNode prev;
		LLNode(ArrayList<Integer> content){
			this.next = null;
			this.content = content;
			this.prev = null;
		}
	}
	private LLNode head;
    public ZigzagIteratorII(ArrayList<ArrayList<Integer>> vecs){
    	head = null;
    	LLNode cur = null;
    	for(ArrayList<Integer> vec: vecs){
    		if(vec.size() != 0){
    			if(head == null){
    				head = new LLNode(vec);
    				cur = head;
    			}else{
    				LLNode tmp = new LLNode(vec);
    				cur.next = tmp;
    				tmp.prev = cur;
    				cur = tmp;
    			}
    		}
    	}
    	if(head != null){
    		cur.next = head;
    		head.prev = cur;
    	}
    }
    public int next(){
    	if(hasNext()){
    		int res = head.content.remove(0);
    		if(head.content.size() == 0){
    			if(head.next == head)
    				head = null;
    			else{
    				head.prev.next = head.next;
    				head.next.prev = head.prev;
    				head = head.next;
    			}
    		}else{
    			head = head.next;
    		}
    		return res;
    	}else{
    		return -1;
    	}
    }
    public boolean hasNext() {
    	return head != null;
    }
    public static void main(String[] args) {
    	ArrayList<ArrayList<Integer>> vecs = new ArrayList<ArrayList<Integer>>();
    	vecs.add(new ArrayList<Integer>());
    	ArrayList<Integer> tmp = new ArrayList<Integer>();
    	tmp.add(1); tmp.add(7); tmp.add(5); tmp.add(10); tmp.add(2);
    	vecs.add(tmp);
    	vecs.add(new ArrayList<Integer>());
    	tmp = new ArrayList<Integer>();
    	tmp.add(2); tmp.add(1);
    	vecs.add(tmp);
    	ZigzagIteratorII iter = new ZigzagIteratorII(vecs);
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	while(iter.hasNext()){
    		int num = iter.next();
    		res.add(num);
    	}
    	System.out.println(res.toString());
    }
}