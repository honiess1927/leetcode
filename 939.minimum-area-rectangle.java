class Solution {
    public int minAreaRect(int[][] points) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
        	if (!map.containsKey(point[0])) map.put(point[0], new HashSet<>());
        	map.get(point[0]).add(point[1]);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++)
        	for (int j = i + 1; j < points.length; j++) {
        		res = Math.min(res, getArea(points[i], points[j], map));
        	}
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    private int getArea(int[] point1, int[] point2, Map<Integer, Set<Integer>> map) {
    	int x1 = point1[0], y1 = point1[1];
    	int x2 = point2[0], y2 = point2[1];
    	if (x1 != x2 && y1 != y2 && map.get(x1).contains(y2) && map.get(x2).contains(y1)) {
    		return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    	} else {
    		return Integer.MAX_VALUE;
    	}
    }
}
