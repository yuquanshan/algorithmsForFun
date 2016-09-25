/**
suppose there is a special linked list where its node contains two pointers,
one is regular next pointer, the other is a random pointer which is pointing 
to any node in the list or null.
return a deep copy of the same list. 
*/
import java.util.*;

public class CopyListWithRandomPointer{
	public static RandomListNode copyWithRandPt(RandomListNode head){
		if(head == null)
			return null;
		RandomListNode newhead = new RandomListNode(head.label);
		RandomListNode tmp = head;
		RandomListNode tmp1 = newhead;
		Hashtable<Integer,RandomListNode> hashtable = new Hashtable<Integer,RandomListNode>();
		hashtable.put(newhead.label,newhead);
		while(tmp.next != null){
			tmp1.next = new RandomListNode(tmp.next.label);
			tmp = tmp.next;
			tmp1 = tmp1.next;
			hashtable.put(tmp1.label,tmp1);
		}
		tmp1.next = null;
		tmp1 = newhead;
		tmp = head;
		while(tmp != null){
			if(tmp.random == null)
				tmp1.random = null;
			else{
				tmp1.random = hashtable.get(tmp.random.label);
			}
			tmp = tmp.next;
			tmp1 = tmp1.next;
		}
		
		return newhead;
	}
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		RandomListNode node1 = new RandomListNode(2);
		RandomListNode node2 = new RandomListNode(3);
		head.next = node1;
		node1.next = node2;
		node2.next = null;
		head.random = node2;
		node2.random = node1;
		node1.random = null;
		System.out.println("Current List:");
		RandomListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.label);
			tmp = tmp.next;
		}
		System.out.println("null");
		tmp = head;
		while(tmp != null){
			if(tmp.random != null) 
				System.out.format("%d ",tmp.random.label);
			else
				System.out.format("null ");
			tmp = tmp.next;
		}
		//System.out.println("null");
		head = copyWithRandPt(head);
		System.out.println("\nNew List:");
		tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.label);
			tmp = tmp.next;
		}
		System.out.println("null");
		tmp = head;
		while(tmp != null){
			if(tmp.random != null) 
				System.out.format("%d ",tmp.random.label);
			else
				System.out.format("null ");
			tmp = tmp.next;
		}
		System.out.format("\n");
	}
}