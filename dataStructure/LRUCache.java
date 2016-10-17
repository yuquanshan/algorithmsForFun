/**
* design an LRU cache
public class LRUCache{
	LRUCache(int capacity){}
	public int get(int key){}
	public void set(int key, int value){}	
}
*/
import java.util.*;
class CacheNode{
	int key;
	int value;
	CacheNode next;
	CacheNode(int key, int value){
		this.key = key;
		this.value = value;
		next = null;
	}
}

public class LRUCache{
	private int len; 
	private int maxLen;
	private CacheNode pseudoHead;
	LRUCache(int capacity){
		this.maxLen = capacity;
		this.pseudoHead = new CacheNode(0,0);
	}
	public int get(int key){
		if(pseudoHead.next == null)
			return -1;
		CacheNode tmp = pseudoHead;
		CacheNode daNode = null;
		while(tmp.next != null){
			if(tmp.next.key == key){
				daNode = tmp;
				break;
			}
			tmp = tmp.next;
		}
		if(daNode == null){
			return -1;
		}else{
			tmp = daNode.next;
			daNode.next = tmp.next;
			CacheNode node = pseudoHead;
			while(node.next != null){
				node = node.next;
			}
			node.next = tmp;
			tmp.next = null;
			return tmp.value;
		}
	}
	public void set(int key, int value){
		CacheNode tmp = pseudoHead;
		CacheNode daNode = null;
		while(tmp.next != null){
			if(tmp.next.key == key){
				daNode = tmp;
				break;
			}
			tmp = tmp.next;
		}
		if(daNode == null){
			tmp.next = new CacheNode(key,value);
			len++;
			if(len > maxLen){
				pseudoHead.next = pseudoHead.next.next;
			}
		}else{
			tmp = daNode.next;
			tmp.value = value;
			daNode.next = tmp.next;
			CacheNode node = pseudoHead;
			while(node.next != null){
				node = node.next;
			}
			node.next = tmp;
			tmp.next = null;
		}
	}
	public void printCache(){
		CacheNode tmp = pseudoHead.next;
		while(tmp != null){
			System.out.format("(%d,%d)",tmp.key,tmp.value);
			tmp = tmp.next;
		}
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.set(1,2);
		cache.set(2,3);
		cache.set(3,4);
		cache.set(1,3);
		cache.set(4,5);
		cache.printCache();
	}
}