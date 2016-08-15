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
			while(down - up > 1){	
				mid = up+(down-up)/2;
				if (matrix[mid][0]>elem){
					down = mid;
				}else{
					up = mid;
				}
			}
			int mm = up;
			if(matrix[down][0]<=elem){
			    mm = down;
			}
			int start = 0;
			int end = matrix[up].length-1;
			while(end-start > 1){
			    int m = start + (end-start)/2;
			    if (matrix[mm][m] == elem){
			        return new Tuple(true,up,m);
			    }else if(matrix[mm][m]<elem){
			        start = m+1;
			    }else{
			        end = m;
			    }
			}
			if(matrix[mm][start] == elem){
				return new Tuple(true,mm,start);
			}else if(matrix[mm][end] == elem)
				return new Tuple(true,mm,end);
			else
				return new Tuple(false,-1,-1);
		}
	}

	public static void main(String[] args) {
		int[][] m = {
			{1,3,5,7},
			{10,11,16,20},
			{23,30,34,50}
		};
		Tuple res = searchMatrix(m,7);
		if(res.b == false){
			System.out.println("Cannot find 7.");
		}else{
			System.out.println("Position of 7 is ("+new Integer(res.x).toString()+","+new Integer(res.y).toString()+").");
		}
		res = searchMatrix(m,0);
		if(res.b == false){
			System.out.println("Cannot find 0.");
		}else{
			System.out.println("Position of 0 is ("+new Integer(res.x).toString()+","+new Integer(res.y).toString()+").");
		}
	}
}