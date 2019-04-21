class Solution {
	public int hIndex(int[] citations) {
     //https://leetcode.com/problems/h-index/discuss/70768/Java-bucket-sort-O(n)-solution-with-detail-explanation
		int n = citations.length;
		int[] bucket = new int[n + 1];
		for (int num : citations) {
			if (num > n) bucket[n]++;
			else bucket[num]++;
		}
		int sum = 0;
		for (int i = n; i >= 0; i--) {
			sum += bucket[i];
			if (sum >= i) return i;
		}
		return 0;
	}
}
