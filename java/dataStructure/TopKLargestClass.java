/**
* implement a data structure with two interfaces.
* public void add(int num) - add the new number; 
* public List<Integer> topK() - return k largest numbers, k is initialized at the beginning. 
*/
import java.util.*;

public class TopKLargestClass{
	PriorityQueue<Integer> heap;
	int k;
	TopKLargestClass(int k){
		this.heap = new PriorityQueue<Integer>();
		this.k = k;
	}
	public void add(int num){
		if(heap.size()<k)
			heap.add(num);
		else{
			heap.poll();
			heap.add(num);
		}
	}
	public List<Integer> topK(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<k; i++)
			list.add(heap.poll());
		for(int i = 0; i<k; i++)
			heap.add(list.get(i));
		return list;
	}
	public static void main(String[] args) {
		TopKLargestClass topk = new TopKLargestClass(3);
		topk.add(1);
		topk.add(2);
		topk.add(3);
		topk.add(4);
		List<Integer> list = topk.topK();
		System.out.println(list.toString());
	}
}