/**
* implement an dog-cat shelter which people adopt animals in FIFO fashion, 
* each animal has its name, people can either pick which animal they like 
* (dog or cat), or any kind of animal. 
* public class AnimalShelter{
*	public void enqueue(String name, int type);
*	public String dequeueAny(){}
*	public String dequeueDog(){}
*	public String dequeueCat(){}
* }
*/
import java.util.*;

public class AnimalShelter{
	private Queue<String> catQueue;
	private Queue<String> dogQueue;
	private Queue<Integer> catQueueArr;
	private Queue<Integer> dogQueueArr;
	private int count;
	private int CAT = 0;
	private int DOG = 1;
	AnimalShelter(){
		catQueue = new LinkedList<String>();
		dogQueue = new LinkedList<String>();
		catQueueArr = new LinkedList<Integer>();
		dogQueueArr = new LinkedList<Integer>();
	}
	public void enqueue(String name, int type){
		if(type == CAT){
			catQueue.add(name);
			catQueueArr.add(count);
			count++;
		}
		if(type == DOG){
			dogQueue.add(name);
			dogQueueArr.add(count);
			count++;
		}
	}
	public String dequeueAny(){
		if(dogQueue.peek() == null && catQueue.peek() == null)
			return null;
		if(dogQueue.peek() == null){
			catQueueArr.poll();
			return catQueue.poll();
		}
		if(catQueue.peek() == null){
			dogQueueArr.poll();
			return dogQueue.poll();
		}
		if(dogQueueArr.peek()>catQueueArr.peek()){
			catQueueArr.poll();
			return catQueue.poll();
		}else{
			dogQueueArr.poll();
			return dogQueue.poll();
		}
	}
	public String dequeueDog(){
		dogQueueArr.poll();
		return dogQueue.poll();
	}
	public String dequeueCat(){
		catQueueArr.poll();
		return catQueue.poll();
	}
	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue("harry",1);
		shelter.enqueue("mew",0);
		shelter.enqueue("james",1);
		System.out.format("I adopt cat, get %s\n",shelter.dequeueCat());
		System.out.format("I adopt any, get %s\n",shelter.dequeueAny());
		System.out.format("I adopt dog, get %s\n",shelter.dequeueDog());
	}
}