/**
* given a linked list which may contain a cycle, return the node where the cycle begins.
* return null if there is no cycle.
* public static ListNode returnHead(ListNode head)
*/

public class ReturnCycleHead{
	public static ListNode returnHead(ListNode head){
		if(head == null)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		boolean flag = true;
		while(slow != fast || flag){
		    flag = false;
			if(fast == null || fast.next == null)
				return null;
			else{
				fast = fast.next.next;
			    slow = slow.next;
			}
		}
		slow = head;
		while(slow != fast){
		    slow = slow.next;
		    fast = fast.next;
		}
		return slow;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node = new ListNode(99);
		head.next = node;
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = node;
		System.out.format("The head of the cycle is %d. \n",returnHead(head).val);
	}
}