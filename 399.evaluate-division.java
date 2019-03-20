class Solution {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		for (int i = 0; i < values.length; i++) {
			String a = equations[i][0], b = equations[i][1];
			if (!map.containsKey(a)) map.put(a, new HashMap<>());
			map.get(a).put(b, values[i]);
			if (!map.containsKey(b)) map.put(b, new HashMap<>());
			map.get(b).put(a, 1.0 / values[i]);
		}
		double[] res = new double[queries.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = -1.0;
			String[] query = queries[i];
			if (!map.containsKey(query[0]) || !map.containsKey(query[1])) continue;
			Queue<String> queue = new LinkedList<>();
			Queue<Double> dqueue = new LinkedList<>();
			Set<String> visited = new HashSet<>();
			queue.offer(query[0]);
			dqueue.offer(1.0);
			while (!queue.isEmpty()) {
				String cur = queue.poll();
				double value = dqueue.poll();
				if (cur.equals(query[1])) {
					res[i] = value;
					break;
				}
				if (visited.contains(cur)) continue;
				visited.add(cur);
				if (!map.get(query[0]).containsKey(cur)) {
					map.get(query[0]).put(cur, value);
					map.get(cur).put(query[0], 1.0 / value);
				}
				for (Map.Entry<String, Double> entry : map.get(cur).entrySet()) {
					queue.offer(entry.getKey());
					dqueue.offer(value * entry.getValue());
				}
			}
		}
		return res;
	}
}
