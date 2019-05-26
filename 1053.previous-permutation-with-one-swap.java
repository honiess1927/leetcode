class Solution {
    public int[] prevPermOpt1(int[] A) {
        int j = A.length - 2;
        while (j > 0 && A[j] <= A[j + 1]) j--;
        int i = A.length - 1;
        while (i > j && A[i] >= A[j]) i--;
        while (i > 0 && A[i - 1] == A[i]) i--;
        int swap = A[i];
        A[i] = A[j];
        A[j] = swap;
        return A;
    }
}
