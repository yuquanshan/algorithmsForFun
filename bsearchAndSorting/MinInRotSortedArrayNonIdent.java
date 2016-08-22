/**
find minimum in a rotated sorted *non-identical* array 
*/

public class MinInRotSortedArrayNonIdent{
    public static int findMin(int[] num){
        if(num == null || num.length == 0)
            return -1;
        int min = num[0];
        for(int i = 0; i < num.length-1; i++){
            if (num[i]<min){
                min = num[i];
            }
        }
        return min;  
    }
    public static void main(String[] args) {
        int[] array = {4,4,5,6,7,0,1,2};
        System.out.println("min element is "+findMin(array));
    }
}