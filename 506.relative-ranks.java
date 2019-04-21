class Solution {
    public String[] findRelativeRanks(int[] nums) {
    	int n = nums.length;
    	Integer[] index = new Integer[n];
    	for (int i = 0; i < n; i++) {
    		index[i] = i;
    	}
    	Arrays.sort(index, (a, b) -> Integer.compare(nums[b], nums[a]));
    	String[] res = new String[n];
    	for (int rank = 0; rank < n; rank++) {
    		if (rank == 0) {
    			res[index[rank]] = "Gold Medal";
    		} else if (rank == 1) {
    			res[index[rank]] = "Silver Medal";
    		} else if (rank == 2) {
    			res[index[rank]] = "Bronze Medal";
    		} else {
    			res[index[rank]] = String.valueOf(rank + 1);
    		}
    	}
    	return res;
    }
}
