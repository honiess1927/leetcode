class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int res = 0;
        for (int i = 0; i < houses.length; i++) {
        	int l = 0, r = heaters.length - 1;
        	while (l < r) {
        		int mid = l + (r - l) / 2;
        		if (heaters[mid] >= houses[i]) {
        			r = mid;
        		} else {
        			l = mid + 1;
        		}
        	}
        	int radius = Math.abs(heaters[l] - houses[i]);
        	if (l > 0) radius = Math.min(radius, houses[i] - heaters[l - 1]);
        	res = Math.max(res, radius);
        }
        return res;
    }
}
