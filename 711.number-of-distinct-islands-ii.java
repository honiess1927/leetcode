class Solution {
	public int numDistinctIslands2(int[][] grid) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					List<int[]> list = new ArrayList<>();
					dfs(list, i, j, grid);
					set.add(norm(list));
				}
			}
		}        
		return set.size();
	}

	int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	private void dfs(List<int[]> list, int i, int j, int[][] grid) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) return;
		list.add(new int[]{i, j});
		grid[i][j] = 0;
		for (int[] p : pos) {
			dfs(list, i + p[0], j + p[1], grid);
		}
	}

	// Count all eight possible transformations.
	// (x, y), (x, -y), (-x, y), (-x, -y)
	// (y, x), (-y, x), (y, -x), (-y, -x)
	// Save the first one. (与analogue一样的思想)
	private String norm(List<int[]> list) {
		int[][] transform = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
		List<List<int[]>> normLists = new LinkedList<>();
		for (int[] t : transform) {
			List<int[]> a = new ArrayList<>(), b = new ArrayList<>();
			for (int[] item : list) {
				a.add(new int[] {t[0] * item[0], t[1] * item[1]});
				b.add(new int[] {t[0] * item[1], t[1] * item[0]});
			}
			normLists.add(a);
			normLists.add(b);
		}

		String res = null;
		for (List<int[]> normList : normLists) {
			Collections.sort(normList, (a, b) -> {
				return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
			});
			// (x, y) is the upleft most point, we use it as benchmark
			// to calculate other coordinates.
			int x = normList.get(0)[0], y = normList.get(0)[1];
			StringBuilder sb = new StringBuilder();
			for (int[] item : normList) {
				sb.append(item[0] - x).append(' ').append(item[1] - y).append(' ');
			}
			String str = sb.toString();
			res = res == null ? str : res.compareTo(str) < 0 ? res : str;
		}

		return res;
	}
}
