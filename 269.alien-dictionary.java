class Solution {
    public String alienOrder(String[] words) {
        StringBuilder res = new StringBuilder();
        int[] indegree = new int[26];
        Map<Character, List<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (char ch : words[i].toCharArray()) map.putIfAbsent(ch, new LinkedList<>());
            if (i == 0) continue;
            String pre = words[i - 1], cur = words[i];
            for (int j = 0; j < Math.min(pre.length(), cur.length()); j++) {
                if (cur.charAt(j) != pre.charAt(j)) {
                    map.get(pre.charAt(j)).add(cur.charAt(j));
                    indegree[cur.charAt(j) - 'a']++;
                    break;
                }
            }
        }
        // print(map);
        for (Character ch : map.keySet()) {
            if (indegree[ch - 'a'] == 0) res.append(ch);
        }
        int index = 0;
        while (index < res.length()) {
            char cur = res.charAt(index);
            List<Character> list = map.get(cur);
            map.remove(cur);
            for (char next : list) {
                indegree[next - 'a']--;
                if (indegree[next - 'a'] == 0) res.append(next);
            }
            index++;
        }
        return map.isEmpty() ? res.toString() : "";
    }

    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
