class Solution {
	Map<Integer, List<Integer>> map = new HashMap<>();
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		Set<Integer> set = new HashSet<>();
		int[] ind = new int[org.length + 1];
		for (int i = 1; i <= org.length; i++) {
			set.add(i);
			map.put(i, new LinkedList<>());
		}
		for (List<Integer> seq : seqs) {
			for (Integer x : seq) {
				if (x > org.length || x < 1) return false;
				set.remove(x);
			}
			for (int i = 1; i < seq.size(); i++) {
				map.get(seq.get(i - 1)).add(seq.get(i));
				ind[seq.get(i)]++;
			}
		}
		if (!set.isEmpty()) return false;
		int startPoint = -1;
		for (int i = 1; i <= org.length; i++) {
			if (ind[i] == 0) {
				if (startPoint != -1) return false;
				startPoint = i;
			}
		}
		int index = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startPoint);
		while (!queue.isEmpty()) {
			if (queue.size() != 1) return false;
			int cur = queue.poll();
			if (cur != org[index++]) return false;
			for (int next : map.get(cur)) {
				ind[next]--;
				if (ind[next] == 0) queue.offer(next);
			}
		}
		return index == org.length;
	}
}
