/**
* if multiple nodes have the same value, keep the first one, remove the others.
* public ListNode removeDup(ListNode head)
*/
import java.util.*;

public class RemoveDup{
	public static ListNode removeDup(ListNode head){
		if(head == null)
			return null;
		HashSet<Integer> set = new HashSet<Integer>();
		ListNode tmp = head;
		set.add(tmp.val);
		while(tmp.next != null){
			if(set.contains(tmp.next.val)){
				tmp.next = tmp.next.next;
			}else{
				set.add(tmp.next.val);
				tmp = tmp.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		head.next.next.next.next = new ListNode(4);
		System.out.println("Current list is:");
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		head = removeDup(head);
		System.out.println("After removing duplicate, the list is:");
		tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}