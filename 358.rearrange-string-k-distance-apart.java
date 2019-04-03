class Solution {
	public String rearrangeString(String s, int k) {
		if (k == 0) return s;
		int[] cnt = new int[97 + 26];
		for (char ch : s.toCharArray()) 
			cnt[ch]++;
        //[0] = char [1] = cnt
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
			a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
		for (int i = 97; i < cnt.length; i++) {
			if (cnt[i] > 0) pq.offer(new int[]{i, cnt[i]});
		}
		StringBuilder sb = new StringBuilder();
		Queue<int[]> tempList = new LinkedList<>();
		while (!pq.isEmpty()) {
			int[] cur = pq.poll();
			sb.append((char)cur[0]);
			cur[1]--;
			tempList.offer(cur);
			if (tempList.size() == k) {
				int[] next = tempList.poll();
				if (next[1] > 0) pq.offer(next);
			}
		}
		// System.out.print(sb.toString() + "  ");
		return sb.length() == s.length() ? sb.toString() : "";
	}
}
