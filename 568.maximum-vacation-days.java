class Solution {
	int[][] memo;
    public int maxVacationDays(int[][] flights, int[][] days) {
    	memo = new int[days[0].length][flights.length];
        return dfs(flights, days, 0, 0);
    }

    private int dfs(int[][] flights, int[][] days, int week, int city) {
    	if (week == days[0].length) return 0;
    	if (memo[week][city] != 0) return memo[week][city];
    	int res = days[city][week] + dfs(flights, days, week + 1, city);
    	for (int i = 0; i < flights[0].length; i++) {
    		if (flights[city][i] == 1) {
    			res = Math.max(res, days[i][week] + dfs(flights, days, week + 1, i));
    		}
    	}
    	memo[week][city] = res;
    	return res;
    }
}
