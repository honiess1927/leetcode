class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int index = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) map.put(i, new LinkedList<>());
        int[] indegree = new int[numCourses];
        for (int[] pre : prerequisites) {
        	map.get(pre[1]).add(pre[0]);
        	indegree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
        	if (indegree[i] == 0) {
        		queue.offer(i);
        	}
        }

        while (!queue.isEmpty()) {
        	int cur = queue.poll();
        	res[index++] = cur;
        	for (int next : map.get(cur)) {
        		indegree[next]--;
        		if (indegree[next] == 0) queue.offer(next);
        	}
        }

       return index == numCourses? res : new int[0];
    }
}
