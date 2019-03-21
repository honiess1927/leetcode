class Solution {
	public List<String> findItinerary(String[][] tickets) {
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < tickets.length; i++) {
			String[] ticket = tickets[i];
			if (!map.containsKey(ticket[0])) map.put(ticket[0], new LinkedList<>());
			map.get(ticket[0]).add(i);
		}
		List<String> res = new LinkedList<>();
		for (List<Integer> list : map.values()) {
			Collections.sort(list, (a, b) -> (tickets[a][1].compareTo(tickets[b][1])));
		}
		boolean[] visited = new boolean[tickets.length];
		dfs(res, tickets.length, map, visited, "JFK", tickets);
		return res;
	}

	private boolean dfs(List<String> res, int left, Map<String, List<Integer>> map, boolean[] visited, String curr, String[][] tickets) {
		res.add(curr);
		if (left == 0) return true;
		if (map.containsKey(curr)) {
			for (int tt : map.get(curr)) {
				if (!visited[tt]) {
					visited[tt] = true;
					if (dfs(res, left - 1, map, visited, tickets[tt][1], tickets)) return true;
					visited[tt] = false;
				}
			}
		}
		res.remove(res.size() - 1);
		return false;
	}
}
