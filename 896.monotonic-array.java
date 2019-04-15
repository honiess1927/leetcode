class Solution {
    public boolean isMonotonic(int[] A) {
        boolean increase = false, decrease = false;
        for (int i = 1; i < A.length; i++) {
        	if (A[i] > A[i - 1]) increase = true;
        	if (A[i] < A[i - 1]) decrease = true;
        	if (increase && decrease) return false;
        }
        return true;
    }
}
