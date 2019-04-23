class Solution {
	Map<String, Integer> map = new HashMap<>();
    public int maxVacationDays(int[][] flights, int[][] days) {
        return dfs(flights, days, 0, 0);
    }

    private int dfs(int[][] flights, int[][] days, int week, int city) {
    	if (week == days[0].length) return 0;
    	String key = week + "," + city;
    	if (map.containsKey(key)) return map.get(key);
    	int res = days[city][week] + dfs(flights, days, week + 1, city);
    	for (int i = 0; i < flights[0].length; i++) {
    		if (flights[city][i] == 1) {
    			res = Math.max(res, days[i][week] + dfs(flights, days, week + 1, i));
    		}
    	}
    	map.put(key, res);
    	return res;
    }
}
