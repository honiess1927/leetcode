class Solution {
    public int minMutation(String start, String end, String[] gbank) {
        Set<String> bank = new HashSet<>();
        bank.addAll(Arrays.asList(gbank));
        char[] chars = new char[]{'A', 'C', 'G', 'T'};
        if (!bank.contains(end)) return -1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int res = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int k = 0; k < len; k++) {
                String cur = queue.poll();
                if (end.equals(cur)) return res;
                StringBuilder sb = new StringBuilder(cur);
                for (int i = 0; i < 8; i++) {
                    for (char ch : chars) {
                        if (ch != cur.charAt(i));
                        sb.setCharAt(i, ch);
                        String str = sb.toString();
                        if (bank.contains(str)) {
                            bank.remove(str);
                            queue.offer(str);
                        }
                    }
                    sb.setCharAt(i, cur.charAt(i));
                }
            }
            res++;
        }
        return -1;
    }
}
