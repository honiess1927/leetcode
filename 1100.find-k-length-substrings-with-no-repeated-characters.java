class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S.length() < K) return 0;
        Map<Character, Integer> count = new HashMap<>();
        int dup = 0;
        for (int i = 0; i < K; i++) {
            char ch = S.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
            if (count.get(ch) == 2) dup++;
        }
        int res = dup == 0? 1 : 0;
        for (int i = K; i < S.length(); i++) {
            char ch = S.charAt(i - K);
            count.put(ch, count.get(ch) - 1);
            if (count.get(ch) == 1) dup--;
            ch = S.charAt(i);
            count.put(ch, count.getOrDefault(ch, 0) + 1);
            if (count.get(ch) == 2) dup++;
            if (dup == 0) res++;
        }
        return res;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
