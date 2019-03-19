class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Set<Integer> leaf = new HashSet<>();
		for (int i = 0; i < numCourses; i++) leaf.add(i);
		Map<Integer, Set<Integer>> preq = new HashMap<>();
		Map<Integer, Set<Integer>> succ = new HashMap<>();
		for (int[] p : prerequisites) {
			if (!preq.containsKey(p[1])) {
				preq.put(p[1], new HashSet<>());
				leaf.remove(p[1]);
			}
			preq.get(p[1]).add(p[0]);
			if (!succ.containsKey(p[0])) {
				succ.put(p[0], new HashSet<>());
			}
			succ.get(p[0]).add(p[1]);
		}
		while (!leaf.isEmpty()) {
			Set<Integer> nextLeaf = new HashSet<>();
			numCourses -= leaf.size();
			for (Integer l : leaf) {
				if (!succ.containsKey(l)) continue;
				for (int next : succ.get(l)) {
					preq.get(next).remove(l);
					if (preq.get(next).isEmpty()) nextLeaf.add(next);
				}
			}
			leaf = nextLeaf;
		}
		return numCourses == 0;
	}
}
