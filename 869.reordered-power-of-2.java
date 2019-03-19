class Solution {
	public boolean reorderedPowerOf2(int N) {
		Map<Integer, Integer> n = getMap(N);
		int i = 1;
		final int maximum = 1000000000;
		do {
			if (getMap(i).equals(n)) return true;
			i = i * 2;
		} while (i < maximum);
		return false;
	}

	Map<Integer, Integer> getMap(int num) {
		Map<Integer, Integer> map = new HashMap<>();
		while (num > 0) {
			int t = num % 10;
			map.put(t, map.getOrDefault(t, 0) + 1);
			num = num / 10;
		}
		return map;
	}
}
