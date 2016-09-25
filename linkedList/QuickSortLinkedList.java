/**
use quick sort to sort linked list list in O(nlogn) time and constant space complexity.
*/

// straightforward but convoluted, have to keep a clear mind 
import java.io.*;
import java.util.*;
class SortRes{	// return the starting node and ending node of sorted list
	ListNode start;
	ListNode end;
	SortRes(ListNode start, ListNode end){
		this.start = start;
		this.end = end;
	}
}

public class QuickSortLinkedList{
	public static ListNode sort(ListNode head){
		if(head == null || head.next == null)
			return head;
		int count = 0;
		ListNode tmp = head;
		while(tmp != null){
			tmp = tmp.next;
			count += 1;
		}
		SortRes res = quickSort(head,count);
		return res.start;
	}
	public static SortRes quickSort(ListNode head, int len){
		if(head == null || head.next == null || len == 1)
			return new SortRes(head,head);
		if(len == 0)
			return new SortRes(null,null);
		//System.out.format("head is %d, length is %d\n", head.val, len);
		ListNode tmp = head;
		ListNode nodei = head;
		int x = head.val;
		int count = 0;
		int firsthalflen = 0;
		while(count < len - 1){
			//System.out.format("%d(%d) ",tmp.val,count);
			if(tmp.next.val < x){
				firsthalflen+=1;
				if(nodei == tmp){
					nodei = nodei.next;
				}else if(nodei.next == tmp){ // swapping nodes are adjacent
					ListNode after = tmp.next.next;
					ListNode node2 = tmp.next;
					nodei.next = node2;
					nodei = node2;
					node2.next = tmp;
					tmp.next = after;
					tmp = node2;
				}else{
					ListNode node1 = nodei.next;
					ListNode node2 = tmp.next;
					ListNode after1 = nodei.next.next;
					ListNode after2 = tmp.next.next;
					nodei.next = node2;
					node2.next = after1;
					tmp.next = node1;
					node1.next = after2;
					nodei = node2;
				}
			}
			tmp = tmp.next;
			count += 1;
		}
		tmp = head;
		if(firsthalflen > 0){
			head = head.next;
			tmp.next = nodei.next;
			nodei.next = tmp;
		}
		/*System.out.format("it is:");
		ListNode tmpt = head;
		count = 0;
		while(count < len){
			System.out.format(" %d",tmpt.val);
			tmpt = tmpt.next;
			count += 1;
		}
		System.out.println("");*/
		SortRes res1 = quickSort(head,firsthalflen);
		SortRes res2 = quickSort(tmp.next,len-1-firsthalflen);
		if(res1.start == null){	
			if(res2.end != null){
				tmp.next = res2.start;
				return new SortRes(tmp,res2.end);
			}else
				return new SortRes(tmp,tmp);
		}else{
			res1.end.next = tmp;
			if(res2.end != null){
				tmp.next = res2.start;
				return new SortRes(res1.start,res2.end);
			}else{
				return new SortRes(res1.start,tmp);
			}
		}
	}
	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		head.next = new ListNode(3);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(-1);
		head.next.next.next.next = new ListNode(5);
		/*ListNode head = new ListNode(0);
		ListNode node = head;
		
		String s = "";
		try{
			File in = new File("12.txt");
			FileReader fr = new FileReader(in);
			s = new BufferedReader(fr).readLine();
		}catch(FileNotFoundException e){}catch(IOException e){}
		String[] array = s.split("->");
		for(int i = 0; i < array.length-1; i++){
			node.next = new ListNode(Integer.parseInt(array[i]));
			node = node.next;
		}
		head = head.next;*/
		head = sort(head);
		System.out.println("The sorted list is: ");
		ListNode tmp = head;
		while(tmp != null){
			System.out.format("%d->",tmp.val);
			tmp = tmp.next;
		}
		System.out.println("null");
	}
}