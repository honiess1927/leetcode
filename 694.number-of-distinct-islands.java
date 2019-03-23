class Solution {
	Map<Character, Character> counter = new HashMap<>();
    public int numDistinctIslands(int[][] grid) {
    	counter.put('r', 'l');
    	counter.put('l', 'r');
    	counter.put('u', 'd');
    	counter.put('d', 'u');
    	counter.put('s', 'e');
    	Set<String> set = new HashSet<>();
    	for (int i = 0; i < grid.length; i++) {
    		for (int j = 0; j < grid[0].length; j++) {
    			if (grid[i][j] == 1) {
    				StringBuilder sb = new StringBuilder();
    				dfs(grid, i, j, 'n', sb);
    				String path = sb.toString();
    				set.add(path);
    			}
    		}
    	}
    	return set.size();
    }

    public void dfs(int[][] grid, int x, int y, char move, StringBuilder sb) {
    	if (grid[x][y] == 0) return;
    	grid[x][y] = 0;
    	sb.append(move);
    	if (x > 0) dfs(grid, x - 1, y, 'l', sb);
    	if (x < grid.length - 1) dfs(grid, x + 1, y, 'r', sb);
    	if (y > 0) dfs(grid, x, y - 1, 'u', sb);
    	if (y < grid[0].length - 1) dfs(grid, x, y + 1, 'd', sb);
    	sb.append(counter.get(move));
    }
}
