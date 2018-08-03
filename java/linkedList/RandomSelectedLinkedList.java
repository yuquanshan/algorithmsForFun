/** Given a singly linked list, return a random node's value from the linked list. 
* Each node must have the same probability of being chosen.
* 
* Follow up:
* What if the linked list is extremely large and its length is unknown to you? 
* Could you solve this efficiently without using extra space?
* 
* Example:
* 
* // Init a singly linked list [1,2,3].
* ListNode head = new ListNode(1);
* head.next = new ListNode(2);
* head.next.next = new ListNode(3);
* Solution solution = new Solution(head);
*
* // getRandom() should return either 1, 2, or 3 randomly. Each element should 
* have equal probability of returning.
* solution.getRandom();
* 	public class RandomSelectedLinkedList{
*		public RandomSeletedLinkedList(ListNode head){}
*		public int getRandom(){}
*	}
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
* (using reservior sampling, see https://leetcode.com/problems/linked-list-random-node/
* for proof)
*/
import java.util.*;

public class RandomSelectedLinkedList {
	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}	
    ListNode head;
    Random rand; 
    int k;
    int[] reservior;
    public RandomSelectedLinkedList(ListNode head) {
        this.head = head;
        rand = new Random();
        k = 1;	// can be anything
        reservior = new int[k];
    }
    public int getRandom(){
    	if(head == null)
    		return -1;
    	ListNode node = head;
    	int count = 0;
        while(count < k && node != null){
        	reservior[count] = node.val;
        	node = node.next;
        	count++;
        }
        if(node == null)
        	return reservior[rand.nextInt()%count];
        int acc = k;
        while(node != null){
        	acc++;
        	int i = (acc+rand.nextInt()%acc)%acc;
        	if(i < k){
        		reservior[i] = node.val;	
        	}
        	node = node.next;
        }
        return reservior[rand.nextInt()%k];
    }
}