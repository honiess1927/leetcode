class Solution {
	public int flipgame(int[] fronts, int[] backs) {
		Set<Integer> cannot = new HashSet<>();
		List<Integer> total = new ArrayList<>();
		for (int i = 0; i < fronts.length; i++) {
			if (fronts[i] == backs[i]) cannot.add(fronts[i]);
			total.add(fronts[i]);
			total.add(backs[i]);
		}
		Collections.sort(total);
		for (int x : total) if (!cannot.contains(x)) return x;
			return 0;
	}
}
