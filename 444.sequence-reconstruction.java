class Solution {
	Map<Integer, List<Integer>> map = new HashMap<>();
	public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
		int[] ind = new int[org.length + 1];
		for (List<Integer> seq : seqs) {
			if (seq.size() == 0) continue;
			if (seq.get(0) < 1 || seq.get(0) > org.length) return false;
			map.putIfAbsent(seq.get(0), new LinkedList<>());
			for (int i = 1; i < seq.size(); i++) {
				if (seq.get(i) < 1 || seq.get(i) > org.length) return false;
				map.putIfAbsent(seq.get(i), new LinkedList<>());
				map.get(seq.get(i - 1)).add(seq.get(i));
				ind[seq.get(i)]++;
			}
		}
		if (map.size() != org.length) return false;
		int startPoint = -1;
		for (int i = 1; i <= org.length; i++) {
			if (ind[i] == 0) {
				if (startPoint != -1) return false;
				startPoint = i;
			}
		}
		int index = 0;
		while (startPoint != -1) {
			int cur = startPoint;
			startPoint = -1;
			if (cur != org[index++]) return false;
			for (int next : map.get(cur)) {
				ind[next]--;
				if (ind[next] == 0) {
					if (startPoint != -1) return false;
					startPoint = next;
				}
			}
		}
		return index == org.length;
	}
}
