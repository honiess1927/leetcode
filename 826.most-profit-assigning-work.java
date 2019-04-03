class Solution {
	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		List<Integer> index = new ArrayList<>();
		for (int i = 0; i < difficulty.length; i++) 
			index.add(i);
		Collections.sort(index, (a, b) -> difficulty[a] - difficulty[b]);
		Arrays.sort(worker);
		int i = 0, res = 0, maxProfit = 0;
		for (int j = 0; j < worker.length; j++) {
			while (i < difficulty.length && difficulty[index.get(i)] <= worker[j]) {
				maxProfit = Math.max(maxProfit, profit[index.get(i)]);
				i++;
			}
			res += maxProfit;
		}
		return res;
	}
}
