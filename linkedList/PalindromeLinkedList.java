/**
* check if a linked list is a palindrome.
* public static boolean isPalindrome(ListNode head)
*/
import java.util.*;

public class PalindromeLinkedList{
	public static boolean isPalindrome(ListNode head){
		if(head == null || head.next == null)
			return true;
		ListNode tmp = head;
		int count = 0; 	// get the length of the list
		while(tmp != null){
			count += 1;
			tmp = tmp.next;
		}
		int i = 1;
		tmp = head;
		Stack<ListNode> stack = new Stack<ListNode>();
		while(i <= count){
			if(i <= count/2){
				stack.push(tmp);
			}
			if(i > count - count/2){
				if(tmp.val != stack.pop().val)
					return false;
			}
			tmp = tmp.next;
			i += 1;
		}
		return true;
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.printList();
		if(isPalindrome(head))
			System.out.println("It is a palindrome.");
		else
			System.out.println("It is NOT a palindrome.");
	}
}