/**
* the super ugly number is the number which can only be factored to 
* the provided primes, 1 is also an ugly number. given primes, and 
* an integer n, find nth ugly number.
* (a dumb algorithm was given, and time limit exceeded in my first
* try due to long/int accuracy)
*/
import java.util.*;

public class SuperUglyNumber{
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] process = new int[primes.length];
        for(int i = 0; i<primes.length; i++)
            process[i] = 0;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i<n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j<primes.length; j++){
                min = Math.min(min,primes[j]*res[process[j]]);
            }
            res[i] = min;
            for(int j = 0; j<primes.length; j++){
                if(min == primes[j]*res[process[j]])
                    process[j]++;
            }
        }
        return res[n-1];
    }
    public static void main(String[] args) {
        int n = 300;
        int[] primes = {89,449,499,79,457,311,281,181,271,419,379,347,131};
        System.out.format("The %dth ugly number is %d\n",n,nthSuperUglyNumber(n,primes));
    }
}