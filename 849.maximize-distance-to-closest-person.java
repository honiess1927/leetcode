class Solution {
	public int maxDistToClosest(int[] seats) {
		int pre = -1, maxDist = 0;
		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				if (pre == -1) maxDist = i;
				else maxDist = Math.max(maxDist, (i - pre) / 2);
				pre = i;
			}
		}
		maxDist = Math.max(maxDist, seats.length - 1 - pre);
		return maxDist; 
	}
}
