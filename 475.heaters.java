class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int n = houses.length, m = heaters.length;
        int l = 0, r = Math.max(houses[n - 1], heaters[m - 1]) - Math.min(houses[0], heaters[0]);
        while (l < r) {
        	int mid = l + (r - l) / 2;
        	int i = 0, j = 0;
        	while (i < n && j < m) {
        		int left = heaters[j] - mid, right = heaters[j] + mid;
        		while (i < n && houses[i] >= left && houses[i] <= right) i++;
        		j++;
        	}
        	if (i == n) r = mid;
        	else l = mid + 1;
        }
        return l;
    }

}
