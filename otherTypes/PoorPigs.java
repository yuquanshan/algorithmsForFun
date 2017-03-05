/** There are 1000 buckets, one and only one of them contains poison, 
* the rest are filled with water. They all look the same. If a pig drinks 
* that poison it will die within 15 minutes. What is the minimum amount of 
* pigs you need to figure out which bucket contains the poison within one hour.
*
* Answer this question, and write an algorithm for the follow-up general case.
*
* Follow-up:
*
* If there are n buckets and a pig drinking poison will die within m minutes, 
* how many pigs (x) you need to figure out the "poison" bucket within p minutes? 
* There is exact one bucket with poison.
*
* public int poorPigs(int buckets, int minutesToDie, int minutesToTest)
* (failed to find a way to kill min pigs in my first try, although it's an easy
* problem in leetcode).
*/

public class PoorPigs {
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int partitions = minutesToTest/minutesToDie;
        if(partitions == 0) return 0;
        int tmp = partitions + 1;
        int count = 0;
        buckets--;
        while(buckets > 0) {
            buckets = buckets/tmp;
            count++;
        }
        return count;
	}
	/* 
	explanation: can present the bucket in (x,y,z,...) coordinate, can use one pig to determine
	one dimention, say use pig 1 to determine first coordinate: (0 ~ p - 1, y, z, ...), in p - 1 
	trials, where p = minutesToTest/minutesToDie.
	*/
}