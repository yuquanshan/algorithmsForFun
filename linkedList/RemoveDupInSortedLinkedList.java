/**
given a sorted linked list, remove the duplicated elements from it.
*/

public class RemoveDupInSortedLinkedList{
	public static ListNode removeDup(ListNode head){
		if(head == null)
			return null;
		ListNode tmp = head;
		while(tmp != null){
			ListNode next = tmp.next;
			while(next != null && next.val == tmp.val){
				next = next.next;
			}
			tmp.next = next;
			tmp = next;
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);
		ListNode tmp = head;
		System.out.println("Current Linked List:");
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		head = removeDup(head);
		System.out.println("Processed Linked List:");
		tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}