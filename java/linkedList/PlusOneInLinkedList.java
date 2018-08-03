/** Given a non-negative number represented as a singly linked list of digits, plus one to the number.
* The digits are stored such that the most significant digit is at the head of the list.
* 
* Example:
* 	Input:
* 	1->2->3
*
* Output:
*	1->2->4
*
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
* public ListNode plusOne(ListNode head)
* (try to use iterative solution next time!)
*/

import java.util.*;

public class PlusOneInLinkedList {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
    public static ListNode plusOne(ListNode head) {
    	if(head == null)
    		return new ListNode(1);
    	int cur = 0;
    	Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
    	ListNode node = head;
    	while(node != null){
    		map.put(cur++,node);
    		node = node.next;
    	}   
    	cur--;
    	int passv = 1;
    	while(passv != 0 && cur >= 0){
    		passv = (map.get(cur).val+1)/10;
    		map.get(cur).val = (map.get(cur).val+1)%10;
    		cur--;
    	}
    	if(passv == 0){
    		return head;
    	}else{
    		ListNode nnode = new ListNode(1);
    		nnode.next = head;
    		return nnode;
    	}
    }
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	head = plusOne(head);
    	ListNode cur = head;
    	while(cur != null){
    		System.out.format("%d->",cur.val);
    		cur = cur.next;
    	}
    	System.out.println("null");
    }
}