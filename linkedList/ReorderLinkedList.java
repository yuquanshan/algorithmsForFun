/**
reorder an linked list L0 -> L1 -> L2 -> ... -> Ln-1 -> Ln
to L0 -> Ln -> L1 -> Ln-1 -> ...
*/
import java.util.*;
public class ReorderLinkedList{
	public static ListNode reorder(ListNode head){
		if(head == null)
			return null;
		Hashtable<Integer,ListNode> hashtable = new Hashtable<Integer,ListNode>();
		ListNode tmp = head;
		int idx = 0;
		while(tmp != null){	// break the linked list
			ListNode tmp1 = tmp;
			hashtable.put(idx,tmp);
			tmp = tmp.next;
			tmp1.next = null;
			idx += 1;
		}
		idx -= 1;
		int i = 0;
		for(i = 0; i<(idx+1)/2;i++){
			//System.out.format("%d - %d - %d\n",hashtable.get(i).val,hashtable.get(idx-i).val,hashtable.get(i+1).val);
			hashtable.get(i).next = hashtable.get(idx-i);
			if(i != (idx+1)/2-1)
				hashtable.get(idx-i).next = hashtable.get(i+1);
		}
		if(idx%2 == 0)
			hashtable.get(idx-i+1).next = hashtable.get(i);
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(2);
		head.next = new ListNode(-1);
		head.next.next = new ListNode(0);
		//head.next.next.next = new ListNode(4);
		System.out.println("Current list is:");
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		head = reorder(head);
		System.out.println("Reordered list is:");
		tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}