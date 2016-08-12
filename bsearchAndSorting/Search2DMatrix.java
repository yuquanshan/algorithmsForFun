/**
locate an element in a sorted n*m matrix
*/
class Tuple{
		public final boolean b;
		public final int x;
		public final int y;
		public Tuple(boolean b, int x, int y){
			this.b = b;
			this.x = x;
			this.y = y;
		}
}
public class Search2DMatrix{
	

	public static Tuple searchMatrix(int[][] matrix, int elem){
		int d1 = matrix.length;
		if(matrix == null || d1 == 0 || matrix[0].length==0)
			return new Tuple(false, 0, 0);
		else{
			int up = 0;
			int down = d1-1;
			int mid = 0;
			while(down != up){	
				mid = (down+up)/2;
				if (matrix[mid][0]>elem){
					down = mid-1;
				}else{
					up = mid;
				}
			}
			int ind = SearchInSortedArray.findItRange(matrix[up],elem,0,matrix[0].length);
			if (ind == -1)
				return new Tuple(false, 0, 0);
			else{
				return new Tuple(true, up, ind);
			}
		}
	}

	public static void main(String[] args) {
		int[][] m = {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14}
		};
		Tuple res = searchMatrix(m,1);
		if(res.b == false){
			System.out.println("Cannot find 1.");
		}else{
			System.out.println("Position of 1 is ("+new Integer(res.x).toString()+","+new Integer(res.y).toString()+").");
		}
		res = searchMatrix(m,0);
		if(res.b == false){
			System.out.println("Cannot find 0.");
		}else{
			System.out.println("Position of 0 is ("+new Integer(res.x).toString()+","+new Integer(res.y).toString()+").");
		}
	}
}