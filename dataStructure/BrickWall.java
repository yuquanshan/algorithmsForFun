/**
* There is a brick wall in front of you. The wall is rectangular and 
* has several rows of bricks. The bricks have the same height but 
*different width. You want to draw a vertical line from the top to 
* the bottom and cross the least bricks.
*
* The brick wall is represented by a list of rows. Each row is a list 
* of integers representing the width of each brick in this row from 
* left to right.
*
* If your line go through the edge of a brick, then the brick is not 
* considered as crossed. You need to find out how to draw the line to 
* cross the least bricks and return the number of crossed bricks.
* Input: 
* [[1,2,2,1],
*  [3,1,2],
*  [1,3,2],
*  [2,4],
*  [3,1,2],
*  [1,3,1,1]]
* Output: 2
* public int leastBricks(List<List<Integer>> wall)
*/

import java.util.*;

class Layer {
	public int offset;
	public int row;
	public int acc;
	Layer(int o, int r, int a) {
		offset = o;
		row = r;
		acc = a;
	}
}

public class BrickWall {
	public int leastBricks(List<List<Integer>> wall) {
		if (wall == null || wall.size() == 0) return 0;
		PriorityQueue<Layer> heap = new PriorityQueue<Layer>(new Comparator<Layer>() {
			public int compare(Layer l1, Layer l2) {
				return l1.acc - l2.acc;
			}
		});
		int layern = wall.size();
		int row = 0; int rowWidth = 0; int best = layern;
		for (List<Integer> layer: wall) heap.add(new Layer(0, row++, layer.get(0)));
		for (int i: wall.get(0)) rowWidth += i;
		if (rowWidth == 0) return 0;
		while (!heap.isEmpty()) {
			int val = heap.peek().acc;
			if (val == rowWidth) break;
			int count = 0;
			while (heap.peek().acc == val) {
				Layer tmp = heap.poll();
				tmp.acc += wall.get(tmp.row).get(++tmp.offset);
				count++;
			}
			if (layern - count < best) best = layern - count;
		}
		return best;
	}
}