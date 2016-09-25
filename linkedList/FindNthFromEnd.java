/**
find nth node from end in the linked list.
*/

public class FindNthFromEnd{
	public static ListNode findNtoEnd(ListNode head, int n){
		if(head == null || n < 1)
			return null;
		ListNode senti = head;
		for(int i = 0; i < n-1; i++){
			senti = senti.next;
			if(senti == null)
				return null;
		}
		ListNode rear = head;
		while(senti.next != null){
			senti = senti.next;
			rear = rear.next;
		}
		return rear;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(5);
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
		int n = 2;
		System.out.format("The %dth node from end is %d\n",n,findNtoEnd(head,n).val);
	}
}