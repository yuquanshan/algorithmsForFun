/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * Each rectangle is defined by its bottom left corner and top right corner 
 * as shown in the figure. Rec 1: (A,B), (C,D); Rec 2: (E,F), (G,H)
 *
 * public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
 */

public class TwoRectanglesOverlappingArea {
	public int computeArea(int A, int B, int C, int D, 
		int E, int F, int G, int H) {
		return overlap(A, C, E, G)*overlap(B, D, F, H);
	}
	private int overlap(int a, int b, int c, int d) {
		if (a >= d || b <= c) return 0;
		return Math.min(b,d) - Math.max(a,c);
	}
	public static void main(String[] args) {
		TwoRectanglesOverlappingArea test = new TwoRectanglesOverlappingArea();
		System.out.println(test.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
	}
}