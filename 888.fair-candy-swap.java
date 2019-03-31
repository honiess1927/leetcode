class Solution {
    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> set = new HashSet<>();
        int sumA = 0, sum = 0;
        for (int a : A) {
        	sumA+=a;
        	sum += a;
        	set.add(a);
        }
        for (int b : B) {
        	sum += b;
        }
        sum = sum / 2;
        int takeAway = sumA - sum;
        for (int b : B) {
        	if (set.contains(b + takeAway)) {
        		return new int[]{b + takeAway, b};
        	}
        }
        return new int[0];
    }
}
