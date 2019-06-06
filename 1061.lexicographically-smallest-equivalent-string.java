class Solution {
    public String smallestEquivalentString(String A, String B, String S) {
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) map[i] = i;
        for (int i = 0; i < A.length(); i++) {
            int a = A.charAt(i) - 'a', b = B.charAt(i) - 'a';
            if (map[b] == map[a]) continue;
            if (map[b] > map[a]) union(map, a, b);
            else union(map, b, a);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            int c = ch - 'a';
            sb.append((char)('a' + map[c]));
        }
        return sb.toString();
    }

    private void union(int[] map, int a, int b) {
        int root = map[b];
        for (int i = 0; i < map.length; i++) {
            if (map[i] == root) map[i] = map[a];
        }
    }
}
