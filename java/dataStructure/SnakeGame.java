/** Design a Snake game that is played on a device with 
* screen size = width x height. Play the game online if 
* you are not familiar with the game.
*
* The snake is initially positioned at the top left corner (0,0) with length = 1 unit.
*
* You are given a list of food's positions in row-column order. 
* When a snake eats the food, its length and the game's score both increase by 1.
*
* Each food appears one by one on the screen. For example, the second 
* food will not appear until the first food was eaten by the snake.
*
* When a food does appear on the screen, it is guaranteed that it will 
* not appear on a block occupied by the snake.
*
* Example:
* Given width = 3, height = 2, and food = [[1,2],[0,1]].
*
* Snake snake = new Snake(width, height, food);
* Initially the snake appears at position (0,0) and the food at (1,2).
*
* |S| | |
* | | |F|
* snake.move("R"); -> Returns 0
* | |S| |
* | | |F|
* snake.move("D"); -> Returns 0
* | | | |
* | |S|F|
* snake.move("R"); -> Returns 1 (Snake eats the first food and right 
* after that, the second food appears at (0,1) )
* | |F| |
* | |S|S|
* snake.move("U"); -> Returns 1
* | |F|S|
* | | |S|
* snake.move("L"); -> Returns 2 (Snake eats the second food)
* | |S|S|
* | | |S|
* snake.move("U"); -> Returns -1 (Game over because snake collides with border)
* 	public class SnakeGame {
*    	public SnakeGame(int width, int height, int[][] food) {}
*    	public int move(String direction) {}
*	}
*/
import java.util.*;

public class SnakeGame {	
	Set<Integer> body;
	LinkedList<Integer> foods;
	LinkedList<Integer> snake;
	int eaten;
	int w, h;
	public SnakeGame(int width, int height, int[][] food) {
		w = width;
		h = height;
		eaten = 0;
		foods = new LinkedList<Integer>();
		body = new HashSet<Integer>();
		for(int[] f: food){
			foods.add(f[0]*w+f[1]);
		}
		snake = new LinkedList<Integer>();
		snake.add(0);
		body.add(0);
	}
 	public int move(String direction) {
 		int head = snake.peekFirst();
 		int tail = snake.removeLast();
 		body.remove(tail);
 		int x = head/w;
 		int y = head%w;
 		int tmp = 0;
 		if(direction.equals("U")){
 			if(x == 0 || body.contains((x-1)*w+y))
 				return -1;
 			tmp = (x-1)*w+y;
 		}else if(direction.equals("D")){
 			if(x == h-1 || body.contains((x+1)*w+y))
 				return -1;
 			tmp = (x+1)*w+y;
 		}else if(direction.equals("L")){
 			if(y == 0 || body.contains(x*w+y-1))
 				return -1;
 			tmp = x*w+y-1;
 		}else if(direction.equals("R")){
 			if(y == w-1 || body.contains(x*w+y+1))
 				return -1;
 			tmp = x*w+y+1;
 		}else{
 			return -1;	// illegal op
 		}
 		body.add(tmp);
		snake.addFirst(tmp);
		if(!foods.isEmpty() && foods.peekFirst() == tmp){
			eaten++;
			foods.removeFirst();
			body.add(tail);
		}
		return eaten;
 	}
 	public static void main(String[] args) {
 		int[][] food = {{1,2},{0,1}};
 		SnakeGame snake = new SnakeGame(3, 2, food);
 		System.out.println(snake.move("R"));
 		System.out.println(snake.move("D"));
 		System.out.println(snake.move("R"));
 		System.out.println(snake.move("U"));
 		System.out.println(snake.move("L"));
 		System.out.println(snake.move("U"));
 	}
}