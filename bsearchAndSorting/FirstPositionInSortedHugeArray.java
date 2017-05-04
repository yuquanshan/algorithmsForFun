/**
* given a huge sorted array whose amount of elements is unknown, the element 
* of the array can only be accessed through array.get(k). find the first target.
* public int searchHugeArray(HugeArray reader, int target)
*/

class HugeArray{	// a "fake" huge array
	int[] elements;
	HugeArray(int[] array){
		elements = array;
	}
	int get(int i){
		return elements[i];
	}
	boolean isEmpty(){
		return (elements==null || elements.length==0);
	}
}

public class FirstPositionInSortedHugeArray{
	public static int searchHugeArray(HugeArray reader, int target){
		if(reader.get(0) == target)
			return 0;
		int ini = 1; 	// we want to find a place which is larger than target
		while(reader.get(ini)<target){
			ini = ini*2;
		}
		int end = ini;
		int start = ini/2;
		while(end - start > 1){
			int mid = start+(end-start)/2;
			if(reader.get(mid)>=target){
				end = mid;
			}else{
				start = mid;
			}
		}
		if (reader.get(start)==target) {
			return start;
		}else if (reader.get(end)==target){
			return end;
		}else{
			return -1;
		}
	}
	public static void main(String[] args) {
		int[] initial = {2,6,8,13,15,17,18,19,20};
		HugeArray array = new HugeArray(initial);
		int target = 15;
		int res = searchHugeArray(array,target);
		if (res == -1) {
		 	System.out.println("Cannot find target!");	
		}else{
			System.out.println("First position is "+res);
		}
	}
}