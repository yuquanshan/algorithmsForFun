/* Suppose you have a random list of people standing in a queue. 
* Each person is described by a pair of integers (h, k), where h is 
* the height of the person and k is the number of people in front of 
* this person who have a height greater than or equal to h. 
* Write an algorithm to reconstruct the queue.
* for example,
*	Input:
*	[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
*	Output:
*	[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
* public int[][] reconstructQueue(int[][] people)
*/
import java.util.*;

public class ReconstructQueue{
	static class People{
		int height;
		int numhigher;
		People(int height, int numhigher){
			this.height = height;
			this.numhigher = numhigher;
		}
	}
	public static int[][] reconstructQueue(int[][] people){
		if(people == null || people.length == 0)
            return people;
		int[][] res = new int[people.length][people[0].length];
		ArrayList<People> list = new ArrayList<People>();
		for(int[] p: people){
			list.add(new People(p[0], p[1]));
		}
		Collections.sort(list, new Comparator<People>(){
			public int compare(People p1, People p2){
				if(p1.height != p2.height)
					return p2.height - p1.height;
				else
					return p1.numhigher - p2.numhigher;
			}
		});
		for(int i = 0; i<list.size(); i++){
			People tmp = list.remove(i);
			list.add(tmp.numhigher,tmp);
		}
		for(int i = 0; i<list.size(); i++){
			res[i][0] = list.get(i).height;
			res[i][1] = list.get(i).numhigher;
		}
		return res;
	}
	public static void main(String[] args) {
		int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] res = reconstructQueue(people);
		System.out.println("One valid solution is ");
		for(int[] r: res)
			System.out.println(Arrays.toString(r));
	}
}