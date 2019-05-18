class Solution {
    public int maxProduct(String[] words) {
        Map<Character, Set<Integer>> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < words.length; i++) {
          boolean[] flag = new boolean[i];
          for (char ch : words[i].toCharArray()) {
            if (!map.containsKey(ch)) {
              map.put(ch, new HashSet<>());
            }
            if (!map.get(ch).contains(i)) {
              for (int j : map.get(ch)) {
                flag[j] = true;
              }
              map.get(ch).add(i);
            }
          }
          for (int j = 0; j < i; j++) {
            if (!flag[j]) res = Math.max(res, words[j].length() * words[i].length());
          }
        }
        return res;
    }
}
