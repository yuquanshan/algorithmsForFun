/** 
 * There are N gas stations along a circular route, where the amount of gas at 
 * station i is gas[i].
 *
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to 
 * travel from station i to its next station (i+1). You begin the journey with 
 * an empty tank at one of the gas stations.
 *
 * Return the starting gas station's index if you can travel around the circuit 
 * once, otherwise return -1.
 *
 * Note:
 * The solution is guaranteed to be unique.
 *
 * public int canCompleteCircuit(int[] gas, int[] cost) 
 */

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0) return -1;
		int len = gas.length;
		int s = 0;	// start point
		int sum = gas[s] - cost[s];
		int pt = (s + 1)%len;
		while(s != pt) {
			if (sum >= 0) {
				sum += gas[pt] - cost[pt];
				pt = (pt + 1) % len;
			} else {
				s = (s - 1 + len) % len;
				sum += gas[s] - cost[s];
			}
		}
		if (sum >= 0) return s;
		else return -1;
	}
	public static void main(String[] args) {
		int[] gas = {1,2,3,3};
		int[] cost = {2,1,5,1};
		GasStation test = new GasStation();
		System.out.println(test.canCompleteCircuit(gas, cost));
	}
}