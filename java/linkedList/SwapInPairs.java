/**
* in a linked list, swap adjacent nodes in pairs, e.g.,
* 1->2->3->4 should be 2->1->4->3.
* public ListNode swapInPairs(ListNode head)
*/

public class SwapInPairs{
	public static ListNode swapInPairs(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode tmp = head.next;	// swap first two nodes
		head.next = tmp.next;
		tmp.next = head;
		head = tmp;
		tmp = head.next;
		while(tmp.next != null && tmp.next.next != null){
			ListNode firnode = tmp.next;
			ListNode secnode = tmp.next.next;
			tmp.next = secnode;
			firnode.next = secnode.next;
			secnode.next = firnode;
			tmp = tmp.next.next;
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		head = swapInPairs(head);
		System.out.println("After swapping, the list is:");
		tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}