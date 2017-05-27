/**
* find the middle node of linked list.
* public ListNode middle(ListNode head)
*/

public class MiddleNode{
	public static ListNode middle(ListNode head){
		if(head == null || head.next == null)
			return null;
		int count = 0;
		ListNode tmp = head;
		while(tmp != null){
			tmp = tmp.next;
			count+=1;
		}
		int idx = (count+1)/2-1;
		count = 0;
		tmp = head;
		while(count < idx){
			tmp = tmp.next;
			count+=1;
		}
		return tmp;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		//head.next.next = new ListNode(3);
		ListNode middle = middle(head);
		System.out.format("The middle node is %d.\n",middle.val);
	}
}