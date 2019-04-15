class Solution {
	public int minIncrementForUnique(int[] A) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (int num : A) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		Arrays.sort(A);
		int res = 0, next = 0;
		for (int num : A) {
			if (map.get(num) > 1) {
				next = Math.max(next, num + 1);
				while (map.containsKey(next)) next++;
				map.put(next, 1);
				res += next - num;
				map.put(num, map.get(num) - 1);
				// System.out.println(num + " " + next);
			}
		}
		return res;
	}
}
