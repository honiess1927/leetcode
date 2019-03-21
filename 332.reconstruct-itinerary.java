class Solution {
	public List<String> findItinerary(String[][] tickets) {
		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (String[] ticket : tickets) {
			map.putIfAbsent(ticket[0], new PriorityQueue<>());
			map.get(ticket[0]).add(ticket[1]);
		}
		LinkedList<String> res = new LinkedList<>();
		dfs(map, res, "JFK");
		return res;
	}

	private void dfs(Map<String, PriorityQueue<String>> map, LinkedList<String> res, String cur) {
		if (map.containsKey(cur)) {
			PriorityQueue<String> pq = map.get(cur);
			while (!pq.isEmpty()) dfs(map, res, pq.poll());
		}
		res.addFirst(cur);
	}
}
