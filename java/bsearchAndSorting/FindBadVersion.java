/**
* A version chain (SVNRepo) can be accessed from 1 to n, 
* a bad version was submitted causing it and its following
* version(s) to be bad. How to verify if a version k is bad:
*	SVNRepo.isBadVersion(k)
* public int findFirstBadVersion(int n)
*/

class SVNRepo{
	static int firstBadVersion = 4;
	public static boolean isBadVersion(int k){
		return k >= firstBadVersion;
	}
}

public class FindBadVersion{
	public static int findFirstBadVersion(int n){
		if(!SVNRepo.isBadVersion(n))	// if there is no bad version at all (i.e., even version n is good).
			return -1;
		int left = 1;
		int right = n;
		while(right - left > 1){
			int mid = left + (right - left)/2;
			if (SVNRepo.isBadVersion(mid)) {
				right = mid;
			}else{
				left = mid;
			}
		}
		if(SVNRepo.isBadVersion(left))
			return left;
		else
			return right;
	}
	public static void main(String[] args) {
		System.out.println("The first bad version is " + findFirstBadVersion(5) + ".");	// should be 4 as defined in SVNRepo
	}
}