/**
* reverse a linked list.
* public ListNode reverse(ListNode head)
*/

public class ReverseLinkedList{
	public static ListNode reverse(ListNode head){
		if(head == null || head.next == null)
			return head;
		ListNode newHead = head;
		head = head.next;
		newHead.next = null;
		while(head != null){
			ListNode tmp = head.next;
			head.next = newHead;
			newHead = head;
			head = tmp;
		}
		return newHead;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		System.out.println("Current linked list is ");
		head.printList();
		System.out.println("Reversed linked list is ");
		head = reverse(head);
		head.printList();
	}
}