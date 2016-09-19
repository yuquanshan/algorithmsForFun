/**
given a linked list, and a value of a node, x, make all node less than x come before nodes greater than or equal to x,
preserve the order of original linked list.
*/

public class PartitionLinkedList{
	public static ListNode partition(ListNode head, int x){
		if(head == null)
			return null;
		ListNode head1 = null; // list storing those less than x
		ListNode tail1 = null;
		ListNode head2 = null;
		ListNode tail2 = null;
		ListNode tmp = head;
		ListNode tmp2 = null;
		while(tmp != null){
			if(tmp.val >= x){ 	// put to list 2
				if(head2 == null){
					head2 = tmp;
					tail2 = tmp;
				}else{
					tail2.next = tmp;
					tail2 = tmp;
				}
			}else{				// put to list 1
				if(head1 == null){
					head1 = tmp;
					tail1 = tmp;
				}else{
					tail1.next = tmp;
					tail1 = tmp;
				}
			}
			tmp2 = tmp;
			tmp = tmp.next;
			tmp2.next = null;
		}
		if(head1 != null){
			tail1.next = head2;
			return head1;
		}else{
			return head2;
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);
		ListNode tmp = head;
		System.out.println("Current Linked List:");
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		head = partition(head,3);
		tmp = head;
		System.out.println("Partitioned Linked List:");
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}