public class Solution {
    public int longestSubstring(String s, int k) {
      if (s.isEmpty()) return 0;
      int[] count = new int[26];
      int notFufilled = 0;
      for (char ch : s.toCharArray()) {
        int index = ch - 'a';
        if (count[index] == 0) notFufilled++;
        count[ch - 'a']++;
        if (count[index] == k) notFufilled--;
      }
      if (notFufilled == 0) return s.length();
      int start = 0, cur = 0, res = 0;
      while (start < s.length()) {
        while (cur < s.length() && count[s.charAt(cur) - 'a'] >= k) cur++;
        // print(s, start, cur);
        res = Math.max(res, longestSubstring(s.substring(start, cur), k));
        start = cur + 1;
        cur++;
      }
      return res;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
