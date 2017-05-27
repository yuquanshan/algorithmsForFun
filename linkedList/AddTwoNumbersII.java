/**
* numbers are presented in linked list as follows,
* 617 => 6->1->7,
* add two numbers, return the result represented as linked list.
* public static ListNode add(ListNode l1, ListNode l2)
* public ListNode add(ListNode l1, ListNode l2)
*/

public class AddTwoNumbersII{
	public static ListNode add(ListNode l1, ListNode l2){
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		l1 = reverseList(l1);
		l2 = reverseList(l2);
		int pass = 0;
		ListNode pseudoHead = new ListNode(0);
		ListNode tmp = pseudoHead;
		while(l1 != null || l2 != null || pass != 0){
			int n1 = 0;
			int n2 = 0;
			if(l1 != null){
				n1 = l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				n2 = l2.val;
				l2 = l2.next;
			}
			ListNode node = new ListNode((n1+n2+pass)%10);
			pass = (n1+n2+pass)/10;
			tmp.next = node;
			tmp = node;
		}
		return reverseList(pseudoHead.next);
	}
	public static ListNode reverseList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode currHead = null;
		ListNode tmp = head;
		while(tmp != null){
			ListNode mid = tmp;
			tmp = tmp.next;
			mid.next = currHead;
			currHead = mid;
		}
		return currHead;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.next = new ListNode(1);
		l1.next.next = new ListNode(2);
		l1.printList();
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(5);
		l2.next.next.next = new ListNode(1);
		l2.printList();
		ListNode res = add(l1,l2);
		res.printList();
	}
}