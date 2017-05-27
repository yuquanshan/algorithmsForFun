/**
* merge two sorted linked list.
* public ListNode merge(ListNode l1, ListNode l2)
*/

public class MergeTwoLists{
	public static ListNode merge(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode pseudohead = new ListNode(0);
		ListNode tmp = pseudohead;
		while(l1 != null || l2 != null){
			if(l1 == null){
				tmp.next = l2;
				l2 = l2.next;
				tmp = tmp.next;
			}else if(l2 == null){
				tmp.next = l1;
				l1 = l1.next;
				tmp = tmp.next;
			}else{
				if(l1.val <= l2.val){
					tmp.next = l1;
					l1 = l1.next;
					tmp = tmp.next;
				}else{
					tmp.next = l2;
					l2 = l2.next;
					tmp = tmp.next;
				}
			}
		}
		tmp.next = null;
		return pseudohead.next;
	}
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(3);
		head1.next.next = new ListNode(8);
		head1.next.next.next = new ListNode(11);
		head1.next.next.next.next = new ListNode(15);
		head1.printList();
		ListNode head2 = new ListNode(2);
		head2.printList();
		System.out.println("Merged list is: ");
		ListNode head = merge(head1,head2);
		head.printList();
	}
}