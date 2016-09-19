/**
given a sorted linked list, remove *all* duplicated nodes from list.
e.g.,
1->1->2->3->3->4->4
should be
2
*/

public class RemoveAllDupInSortedLinkedList{
	public static ListNode removeAllDup(ListNode head){
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		// if head is duplicated, find new head
		while(head.next != null && head.next.val == head.val){
			while(head.next != null && head.next.val == head.val){
				head = head.next;
			}
			head = head.next;
			if(head == null)
				return head;
		}
		ListNode father = head;
		ListNode son = head.next;
		while(son != null){
			if(son.next != null && son.val == son.next.val){	// if son is a dup
				while(son.next != null && son.val == son.next.val){
					son = son.next;
				}
				son = son.next;
				father.next = son;
			}
			if(son != null){
				if(son.next == null || son.val != son.next.val){
					father = son;
					son = son.next;
				}
			}
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(4);
		ListNode tmp = head;
		System.out.println("Current Linked List:");
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		head = removeAllDup(head);
		System.out.println("Processed Linked List:");
		tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}