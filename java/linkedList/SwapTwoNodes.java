/**
* swap two nodes with values v1, v2, in a linked list.
* the linked list doesn't have duplicated nodes, and if there is no such lists do nothing.
* public static ListNodes swap(ListNode head, int v1, int v2)
*/

public class SwapTwoNodes{
	public static ListNode swap(ListNode head, int v1, int v2){
		if(head == null || head.next == null || v1 == v2)
			return head;
		ListNode pseudoHead = new ListNode(0);
		pseudoHead.next = head;
		ListNode tmp = pseudoHead;
		ListNode p1 = null;	// parent of v1
		ListNode p2 = null; // parent of v2
		while(tmp.next != null){
			if(tmp.next.val == v1)
				p1 = tmp;
			if(tmp.next.val == v2)
				p2 = tmp;
			tmp = tmp.next;
		}
		if(p1 == null || p2 == null)	// then either v1 or v2 doesn't exist
			return head;
		if(p1.next == p2){	// if adjacent
			tmp = p2.next.next;
			p1.next = p2.next;
			p2.next.next = p2;
			p2.next = tmp;
			return pseudoHead.next;
		}
		if(p2.next == p1){	// if adjacent
			tmp = p1.next.next;
			p2.next = p1.next;
			p1.next.next = p1;
			p1.next = tmp;
			return pseudoHead.next;
		}
		ListNode son1 = p1.next.next;
		ListNode son2 = p2.next.next;
		ListNode node1 = p1.next;
		ListNode node2 = p2.next;
		p1.next = node2;
		node2.next = son1;
		p2.next = node1;
		node1.next = son2;
		return pseudoHead.next;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		System.out.println("Original list:");
		head.printList();
		int v1 = 2;
		int v2 = 4;
		head = swap(head,v1,v2);
		System.out.format("List after swapping %d and %d is:\n",v1,v2);
		head.printList();
	}
}