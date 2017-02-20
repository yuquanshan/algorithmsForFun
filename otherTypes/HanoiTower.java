/** solve Hanoi Tower problem, print all the moves
* n plates on pillar a, you want to move them to pillar c,
* bigger plate must be at the bottom.
* public void hannoiMoves(int n, int a, int b, int c)
*/

public class HanoiTower {
	public void hannoiMoves(int n, int a, int b, int c) {
		if(n <= 0) return;
		hannoiMoves(n - 1, a, c, b);
		System.out.format("move %d from %d to %d\n", n, a, c);
		hannoiMoves(n - 1, b, a, c);
	}
	public static void main(String[] args) {
		HanoiTower ht = new HanoiTower();
		ht.hannoiMoves(3, 1, 2, 3);
	}
}