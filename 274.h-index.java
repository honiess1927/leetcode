class Solution {
	public int hIndex(int[] citations) {
		Integer[] cit = new Integer[citations.length];
		for (int i = 0; i < cit.length; i++) 
			cit[i] = citations[i];
		if (cit.length == 0) return 0;
		if (cit.length == 1 && cit[0] != 0) return 1;
		Arrays.sort(cit, (a, b) -> Integer.compare(b, a));
		for (int i = 0; i < cit.length; i++) {
			if (cit[i] >= (i + 1) && (i == cit.length - 1 || cit[i + 1] <= (i + 1))) return (i + 1);
		}
		return 0;
	}
}
