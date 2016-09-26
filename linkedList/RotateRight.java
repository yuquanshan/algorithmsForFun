/**
rotate the linked list by k places, e.g.,
given 1->2->3->4->5 and k=2, return 4->5->1->2->3.
*/

public class RotateRight{
	public static ListNode rotateRight(ListNode head, int k){
		if(head == null || head.next == null)
			return head;
		// link head and tail together
		ListNode tmp = head;
		int count = 1;
		while(tmp.next != null){
			tmp = tmp.next;
			count += 1;
		}
		tmp.next = head;
		int whichCut = count - k%count;
		count = whichCut;
		tmp = head;
		for(int i = 1; i < count; i++){
			tmp = tmp.next;
		}
		ListNode res = tmp.next;
		tmp.next = null;
		return res;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println("Current list is:");
		head.printList();
		int k = 2;
		head = rotateRight(head,k);
		System.out.format("List after rotated by %d is:\n",k);
		head.printList();
	}
}