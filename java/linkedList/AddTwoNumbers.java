/**
* assume numbers are expressed as linked lists, with least significant number 
* is the value of list head, e.g.,
* 617: 7->1->6.
* get the sum of two numbers.
* public static ListNode add(ListNode l1, ListNode l2) 
*/

public class AddTwoNumbers{
	public static ListNode add(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode next1 = l1.next;
		ListNode next2 = l2.next;
		ListNode head = new ListNode((l1.val+l2.val)%10);
		ListNode tmp = head;
		int passnumber = (l1.val+l2.val)/10;
		while(next1 != null || next2 != null){
			int val1 = 0;
			int val2 = 0;
			if(next1 != null){
				val1 = next1.val;
				next1 = next1.next;
			}else{
				val1 = 0;
			}
			if(next2 != null){
				val2 = next2.val;
				next2 = next2.next;
			}else{
				val2 = 0;
			}
			ListNode node = new ListNode((val1+val2+passnumber)%10);
			passnumber = (val1+val2+passnumber)/10;
			tmp.next = node;
			tmp = tmp.next;
		}
		if(passnumber > 0){
			tmp.next = new ListNode(passnumber);
		}
		return head;
	}
	public static void main(String[] args) {
		ListNode head1 = new ListNode(3);
		head1.next = new ListNode(1);
		head1.next.next = new ListNode(5);
		ListNode head2 = new ListNode(5);
		head2.next = new ListNode(9);
		//head2.next.next = new ListNode(2);
		ListNode tmp = head1;
		System.out.println("First list:");
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		System.out.println("Second list:");
		tmp = head2;
		System.out.println("First list:");
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		ListNode head = add(head1,head2);
		System.out.println("Addtion result:");
		tmp = head;
		System.out.println("First list:");
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}