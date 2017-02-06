/**
* design an LRU cache
*	public class LRUCache{
*		LRUCache(int capacity){}
*		public int get(int key){}
*		public void set(int key, int value){}	
*	}
* (peeked the hint/label "linked list" in the first time)
*/
import java.util.*;

public class LRUCache{
	int capacity;
	HashMap<Integer,DoubleLL> knMap;
	HashMap<Integer,Integer> kvMap;
	DoubleLL head;	// we should always evict head
	DoubleLL tail;
	int count;
	public LRUCache(int capacity) {
        this.capacity = capacity;
        knMap = new HashMap<Integer, DoubleLL>();
        kvMap = new HashMap<Integer, Integer>();
        head = null;
        tail = null;
        count = 0;
    }
    public int get(int key) {
        if(knMap.containsKey(key) && capacity > 0){
        	DoubleLL node = knMap.get(key);
        	if(node != tail){
        		if(node == head){
        			head = node.next;
        			head.prev = null;
        		}else{
        			node.prev.next = node.next;
        			node.next.prev = node.prev;
        		}
        		tail.next = node;
        		node.next = null;
        		node.prev = tail;
        		tail = node;
        	}
        	return kvMap.get(key);
        }else{
        	return -1;
        }
    }

    public void set(int key, int value) {
        if(capacity == 0){
        	return;
        }else if(knMap.containsKey(key)){
        	kvMap.put(key,value);
        	get(key);	// mark recent use
        }else{
        	DoubleLL node = new DoubleLL(key);
        	kvMap.put(key,value);
        	knMap.put(key, node);
        	if(capacity == count){ // need to evict
        		int keytoevict = head.val;
        		head = head.next;
        		if(tail.val == keytoevict)
        			tail = null;
        		else
        			head.prev = null;
        		kvMap.remove(keytoevict);
        		knMap.remove(keytoevict);
        	}else
        		count++;
        	if(head == null){
        		head = node;
        		tail = node;
        	}else{
        		tail.next = node;
        		node.prev = tail;
        		tail = node;
        	}
        }
    }
    public void printCache(){
    	DoubleLL tmp = head;
    	while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
    }
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(1);
		cache.set(2,1);
		System.out.println(cache.get(2));
		cache.set(3,2);
		cache.printCache();
		System.out.println(cache.get(3));
	}
}