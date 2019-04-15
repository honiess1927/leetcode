class Solution {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int next = 0, res = 0;
        for (int num : A) {
        	next = Math.max(next, num);
        	res += next - num;
        	next++;
        }
        return res;
    }
}
