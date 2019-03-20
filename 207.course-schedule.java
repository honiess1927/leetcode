class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int[] pre : prerequisites) {
			if (!map.containsKey(pre[0])) map.put(pre[0], new LinkedList<>());
			map.get(pre[0]).add(pre[1]);
			indegree[pre[1]]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) queue.offer(i);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			numCourses--;
			if (map.containsKey(cur)) {
				for (int next : map.get(cur)) {
					indegree[next]--;
					if (indegree[next] == 0) queue.offer(next);
				}
			}
		}
		return numCourses == 0;
	}
}
