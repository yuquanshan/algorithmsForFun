/**
* in a linked list with duplicated elements, remove duplicated ones 
* so that each node has unique value.
* public static ListNode removeDup(ListNode head) 
*/

public class RemoveDupInSortedList{
	public static ListNode removeDup(ListNode head){
		if(head == null)
			return null;
		ListNode tmp = head;
		while(tmp.next != null){
			if(tmp.next.val == tmp.val){
				while(tmp.next.val == tmp.val){
					tmp.next = tmp.next.next;
				}
			}else{
				tmp = tmp.next;
			}
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		System.out.println("Original linked list is: ");
		head.printList();
		System.out.println("The list after dup removal is: ");
		head = removeDup(head);
		head.printList();
	}
}