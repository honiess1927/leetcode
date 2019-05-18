class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;
        int[] cnt = new int[nums.length];
        int res = 1, count = 1;
        cnt[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
          if (nums[i] == 1) {
            cnt[i] = cnt[i - 1] + 1;
            count++;
          } else {
            count = cnt[i - 1] + 1;
          }
          res = Math.max(count, res);
          // print(i, cnt[i], count);
        }
        return res;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
