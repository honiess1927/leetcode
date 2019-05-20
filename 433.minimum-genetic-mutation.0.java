class Solution {
    static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
    }
    public int minMutation(String start, String end, String[] bank) {
        Set<Integer> gBank = new HashSet<>();
        for (String gene : bank) {
            gBank.add(toInt(gene));
        }
        int startInt = toInt(start), endInt = toInt(end);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startInt);
        int res = 0;
        // print(startInt, endInt, gBank, "      ");
        // print(toStr(startInt));

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int step = 0; step < len; step++) {
                int cur = queue.poll();
                // print(toStr(cur));
                if (cur == endInt) return res;
                int mask = 0xFFFC;
                int[] val = new int[]{0, 1, 2, 3};
                for (int i = 0; i < 8; i++) {
                    // print(i);
                    for (int j = 0; j < 4; j++) {
                        int next = cur & mask | val[j];
                        // print(toStr(next));
                        if (gBank.contains(next)) {
                            queue.offer(next);
                            gBank.remove(next);
                        }
                        val[j] = val[j] << 2;
                    }
                    // print("    ");
                    mask = mask << 2 | 3;
                }
            }
            // print(gBank,"             ");
            res++;
        }

        return -1;
    }

    private int toInt(String s) {
        int res = 0;
        for (char ch : s.toCharArray()) {
            res = res | map.get(ch);
            res = res << 2;
        }
        return res >> 2;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}

    private String toStr(int x) {
        int mask = 3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int tmp = mask & x;
            switch (tmp) {
                case 0: sb.append('A');
                break;
                case 1: sb.append('C');
                break;
                case 2: sb.append('G');
                break;
                case 3: sb.append('T');
            }
            x = x >>> 2;
        }
        return sb.reverse().toString();
    }
}
