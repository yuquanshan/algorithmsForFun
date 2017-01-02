/** Design a logger system that receive stream of messages along with its timestamps, each message
* should be printed if and only if it is not printed in the last 10 seconds.
* Given a message and a timestamp (in seconds granularity), return true if the message should be
* printed in the given timestamp, otherwise returns false.
* It is possible that several messages arrive roughly at the same time.
* Example:
* Logger logger = new Logger(); 
* // logging string "foo" at timestamp 1
* logger.shouldPrintMessage(1, "foo"); returns true;
* // logging string "bar" at timestamp 2
* logger.shouldPrintMessage(2, "bar"); returns true;
* // logging string "foo" at timestamp 3
* logger.shouldPrintMessage(3,"foo"); returns false;
* // logging string "bar" at timestamp 8
* logger.shouldPrintMessage(8,"bar"); returns false;
* // logging string "foo" at timestamp 10
* logger.shouldPrintMessage(10,"foo"); returns false;
* // logging string "foo" at timestamp 11
* logger.shouldPrintMessage(11,"foo"); returns true;
*/
import java.util.*;

public class Logger{
	/*static class DoublyLL{
		DoublyLL prev;
		DoublyLL next;
		String msg;
		int timestamp;
		DoublyLL(String msg, int timestamp){
			this.msg = msg;
			this.timestamp = timestamp;
			prev = null;
			next = null;
		}
	}
	private DoublyLL head;
	private DoublyLL tail;
	private HashMap<String, DoublyLL> map;  
	Logger(){
		head = null;
		tail = null;
		map = new HashMap<String, DoublyLL>();
	}
	private DoublyLL remove(String str){
		if(map.containsKey(str)){
			DoublyLL node = map.get(str);
			map.remove(str);
			DoublyLL prev = node.prev;
			DoublyLL next = node.next;
			if(head = node) head = prev;
			if(tail = node) tail = next;
			if(prev != null) prev.next = node.next;
			if(next != null) next.prev = node.prev;
		}else{
			return null;
		}
	}
	private void insert(String str, int timestamp){
		if(!map.containsKey(str)){
			DoublyLL node = new DoublyLL(str, timestamp);
			if(tail == null){
				head = node; tail = node;
			}else{
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
		}
	}
	public boolean shouldPrintMessage(int timestamp, String msg){
		while(head != null && head.timestamp < timestamp-10)
			remove(head.msg);
		if(map.containsKey(msg))
			return false;
		else{
			insert(msg,timestamp);
			return true;
		}
	}*/
	static class Message{
		String msg;
		int timestamp;
		Message(String msg, int timestamp){
			this.msg = msg;
			this.timestamp = timestamp;
		}
	}
	private HashSet<String> set;
	private Queue<Message> queue;
	Logger(){
		queue = new LinkedList<Message>();
		set = new HashSet<String>();
	}
	public boolean shouldPrintMessage(int timestamp, String msg){
		while(!queue.isEmpty() && queue.peek().timestamp <= timestamp - 10){
			Message m = queue.remove(); 
			set.remove(m.msg);
		}
		if(set.contains(msg))
			return false;
		else{
			set.add(msg);
			queue.add(new Message(msg,timestamp));
			return true;
		}
	}
	public static void main(String[] args) {
		Logger logger = new Logger(); 	
		if(logger.shouldPrintMessage(1, "foo"))
			System.out.println("Test1 passed!");

		if(logger.shouldPrintMessage(2, "bar")) 
			System.out.println("Test2 passed!");

		if(!logger.shouldPrintMessage(3,"foo"))
			System.out.println("Test3 passed!");

		if(!logger.shouldPrintMessage(8,"bar"))
			System.out.println("Test4 passed!");

		if(!logger.shouldPrintMessage(10,"foo"))
			System.out.println("Test5 passed!");

		if(logger.shouldPrintMessage(11,"foo"))
			System.out.println("Test6 passed!");
	}
}