/**
reverse a linked list from position m to n.
*/

public class ReverseLinkedListRange{
	public static ListNode reverseRange(ListNode head, int m, int n){
		if(head == null || head.next == null || m == n)
			return head;
		ListNode pseudoHead = new ListNode(0);
		pseudoHead.next = head;
		ListNode senti = pseudoHead;
		for(int i = 0; i < m-1; i++)
			senti = senti.next;
		ListNode rtail = senti.next;
		ListNode rhead = senti.next;
		ListNode next = rhead.next;
		for(int i = 0; i < n - m; i++){
			ListNode tmp = next.next;
			next.next = rhead;
			rhead = next;
			next = tmp;
		}
		rtail.next = next;
		senti.next = rhead;
		return pseudoHead.next;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		System.out.println("The original is: ");
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		int m = 2;
		int n = 4;
		head = reverseRange(head,m,n);
		System.out.format("The [%d,%d] range reversed list is: \n",m,n);
		tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}