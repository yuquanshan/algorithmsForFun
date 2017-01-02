/**
* Design and implement a data structure for Least Frequently Used (LFU) cache.
* 	public class LFUCache {
*    	public LFUCache(int capacity){}   
*    	public int get(int key){}    
*    	public void set(int key, int value){}
*	}
*/
import java.util.*;

class DoubleLL{
	public int val;
	public DoubleLL prev;
	public DoubleLL next;
	DoubleLL(int key){
		val = key;
		prev = null;
		next = null;
	}
}

class FreqHashList{	// Hash List for a freq, under first freq, LRU policy is implemented
	public DoubleLL head;
	public DoubleLL tail;
	HashMap<Integer,DoubleLL> knMap;	// key-node map
	FreqHashList(){
		head = null;
		tail = null;
		knMap = new HashMap<Integer,DoubleLL>();
	}
	public void insertHead(int key){	// insert the head of the list
		if(!knMap.containsKey(key)){
			DoubleLL node = new DoubleLL(key);
			if(head == null){
				head = node;
				tail = node;
			}else{
				node.next = head;
				head.prev = node;
				head = node;
			}
			knMap.put(key,node);
		}
	}
	public void insertTail(int key){
		if(!knMap.containsKey(key)){
			DoubleLL node = new DoubleLL(key);
			if(tail == null){
				head = node;
				tail = node;
			}else{
				node.prev = tail;
				tail.next = node;
				tail = node;
			}
		}
	}
	public void remove(int key){
		if(knMap.containsKey(key)){
			DoubleLL node = knMap.get(key);
			knMap.remove(key);
			if(node.prev == null && node.next == null){
				head = null;
				tail = null;
			}else if(node.prev == null){
				node.next.prev = null;
				head = node.next;
			}else if(node.next == null){
				node.prev.next = null;
				tail = node.prev;
				//System.out.format("now tail is %d\n",tail.val);
			}else{
				node.prev.next = node.next;
				node.next.prev = node.prev;
			}
		}
	}
	public void increaseKey1(int key){	// increase key by one while keeping the current key
		if(knMap.containsKey(key)){
			DoubleLL node = knMap.get(key);
			if(node.next == null){
				DoubleLL nnode = new DoubleLL(key+1);
				tail = nnode;
				nnode.prev = node;
				node.next = nnode;
				knMap.put(key+1,nnode);
			}else if(node.next.val > node.val+1){
				DoubleLL nnode = new DoubleLL(key+1);
				nnode.next = node.next;
				nnode.prev = node;
				node.next.prev = nnode;
				node.next = nnode;
				knMap.put(key+1,nnode);
			}
		}
	}
	public void increaseKey2(int key){	// increase key by one while deleting the current key
		if(knMap.containsKey(key)){
			//System.out.format("Before: "); printList();
			DoubleLL node = knMap.get(key);
			
			if(node.next == null || node.next.val > node.val+1){	// modify not delete this node
				node.val = node.val+1;
				knMap.put(key+1,node);
			}else{	// simply delete this node
				remove(key);
				//System.out.println("xxx");
				/*if(node.prev == null){
					head = node.next;
					head.prev = null;
				}*/
			}
			knMap.remove(key);
			//System.out.format("After: "); printList();
		}
	}
	public boolean isEmpty(){
		return head == null;
	}
	public boolean hasKey(int key){
		return knMap.containsKey(key);
	}
	public void printList(){
		DoubleLL tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}

public class LFUCache {
	int capacity;
	int count;
	HashMap<Integer,FreqHashList> freqHash;
	HashMap<Integer,Integer> kvMap;
	HashMap<Integer,Integer> kfMap;
	FreqHashList freqList;

    public LFUCache(int capacity) {
 		this.capacity = capacity;
 		freqHash = new HashMap<Integer,FreqHashList>();
 		kvMap = new HashMap<Integer,Integer>();
 		freqList = new FreqHashList();
 		kfMap = new HashMap<Integer,Integer>();
 		count = 0;
    }
    public int get(int key) {
    	//System.out.format("get(%d)...\n",key);
        if(kvMap.containsKey(key) && capacity > 0){
        	int res = kvMap.get(key);
        	int freq = kfMap.get(key);
        	FreqHashList tmp = freqHash.get(freq);
        	tmp.remove(key);
        	if(tmp.isEmpty()){
        		freqHash.remove(freq);
        		freqList.increaseKey2(freq);
        		//System.out.format("key %d upgrade freq to %d: 2\n",key,freq+1,freqList.head.val);
        	}else{
        		freqList.increaseKey1(freq);
        		//System.out.format("key %d upgrade freq to %d: 1\n",key,freq+1);
        	}
        	freq++;
        	if(freqHash.containsKey(freq)){
        		freqHash.get(freq).insertHead(key);
        	}else{	
        		tmp = new FreqHashList();
        		tmp.insertHead(key);
        		freqHash.put(freq,tmp);
        	}
        	kfMap.put(key,freq);
        	return res;
        }else{
        	return -1;
        }
    }
    public void set(int key, int value) {
        //System.out.format("set(%d,%d)...\n",key,value);
        if(capacity == 0){
        	return;
        }else if(kvMap.containsKey(key)){
        	kvMap.put(key,value);
        	get(key);	// just for increasing the frequency
        }else{
        	if(capacity == count){ // need to evict
    			int lowestfreq = freqList.head.val;
    			//System.out.format("Lowest freq to evict: %d\n",lowestfreq);
    			//if(freqHash.get(lowestfreq).isEmpty()) System.out.println("What?!");
    			int keytoremove = freqHash.get(lowestfreq).tail.val;
    			//System.out.format("Evict key: %d\n", keytoremove);
    			kvMap.remove(keytoremove);
    			kfMap.remove(keytoremove);
    			freqHash.get(lowestfreq).remove(keytoremove);
    			if(freqHash.get(lowestfreq).isEmpty()){
    				freqHash.remove(lowestfreq);
    				freqList.remove(lowestfreq);
    				//System.out.format("remove freq %d, next cand freq: %d\n", lowestfreq, freqList.head.val);
    			}
    		}else{
    			count++;
    		}

        	kvMap.put(key,value);

    		if(!freqList.hasKey(1)){
    			freqList.insertHead(1);
    			FreqHashList tmp = new FreqHashList();
    			tmp.insertHead(key);
    			freqHash.put(1,tmp);
    		}else{
    			freqHash.get(1).insertHead(key);
    		}
    		kfMap.put(key,1);
        }
    }
    public static void main(String[] args) {
    	LFUCache cache = new LFUCache(2);
    	cache.set(1,1);	
		cache.set(2, 2);
		cache.get(1);       // returns 1
		cache.set(3, 3);    // evicts key 2
		int res = cache.get(2);       // returns -1 (not found)
		if(res == -1)
			System.out.println("Test 1 passed!");
		else
			System.out.println(res);
		cache.get(3);       // returns 3.
		System.out.println(3);
		cache.set(4, 4);    // evicts key 1.
		System.out.println(4);
		cache.get(1);       // returns -1 (not found)
		if(res == -1)
			System.out.println("Test 2 passed!");
		else
			System.out.println(res);
		cache.get(3);       // returns 3
		cache.get(4);       // returns 4
      	
      	/*LFUCache cache = new LFUCache(1);
      	cache.set(2,1);
      	System.out.format("key 2: %d\n",cache.get(2));
      	cache.set(3,2);
      	System.out.format("key 2: %d\n",cache.get(2));
      	System.out.format("key 3: %d\n",cache.get(3));*/
      	/*LFUCache cache = new LFUCache(10);
      	cache.set(10,13);
		cache.set(3,17);
		cache.set(6,11);
		cache.set(10,5);
		cache.set(9,10);
		cache.get(13);
		cache.set(2,19);
		cache.get(2);
		cache.get(3);
		cache.set(5,25);
		cache.get(8);
		cache.set(9,22);
		cache.set(5,5);
		cache.set(1,30);
		cache.get(11);
		cache.set(9,12);
		cache.get(7);
		cache.get(5);
		cache.get(8);
		cache.get(9);
		cache.set(4,30);
		cache.set(9,3);
		cache.get(9);
		cache.get(10);
		cache.get(10);
		cache.set(6,14);
		cache.set(3,1);
		cache.get(3);
		cache.set(10,11);
		cache.get(8);
		cache.set(2,14);
		cache.get(1);
		cache.get(5);
		cache.get(4);
		cache.set(11,4);
		cache.set(12,24);
		cache.set(5,18);
		cache.get(13);
		cache.set(7,23);
		cache.get(8);
		cache.get(12);
		cache.set(3,27);
		cache.set(2,12);
		cache.get(5);
		cache.set(2,9);
		cache.set(13,4);
		cache.set(8,18);
		cache.set(1,7);
		cache.get(6);
		cache.set(9,29);
		cache.set(8,21);
		cache.get(5);
		cache.set(6,30);
		cache.set(1,12);
		cache.get(10);
		cache.set(4,15);
		cache.set(7,22);
		cache.set(11,26);
		cache.set(8,17);
		cache.set(9,29);
		cache.get(5);
		cache.set(3,4);
		cache.set(11,30);
		cache.get(12);
		cache.set(4,29);
		cache.get(3);
		cache.get(9);
		cache.get(6);
		cache.set(3,4);
		cache.get(1);
		cache.get(10);
		cache.set(3,29);
		cache.set(10,28);
		cache.set(1,20);
		cache.set(11,13);
		cache.get(3);
		cache.set(3,12);
		cache.set(3,8);
		cache.set(10,9);
		cache.set(3,26);
		cache.get(8);
		cache.get(7);
		cache.get(5);
		cache.set(13,17);
		cache.set(2,27);
		cache.set(11,15);
		cache.get(12);
		cache.set(9,19);
		cache.set(2,15);
		cache.set(3,16);
		cache.get(1);
		cache.set(12,17);
		cache.set(9,1);
		cache.set(6,19);
		cache.get(4);
		cache.get(5);
		cache.get(5);
		cache.set(8,1);
		cache.set(11,7);
		cache.set(5,2);
		cache.set(9,28);
		cache.get(1);
		cache.set(2,2);
		cache.set(7,4);
		cache.set(4,22);
		cache.set(7,24);
		cache.set(9,26);
		cache.set(13,28);
		cache.set(11,26);*/
    }
}