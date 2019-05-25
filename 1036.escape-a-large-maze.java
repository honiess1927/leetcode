class Solution {
    final static int[][] POS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    final static int n = 1000000;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        Map<Integer, Set<Integer>> blockMap = new HashMap<>();
        for (int[] blocker : blocked) {
            blockMap.putIfAbsent(blocker[0], new HashSet<>());
            blockMap.get(blocker[0]).add(blocker[1]);
        }
        return !isBlocked(blockMap, source, target) && !isBlocked(blockMap, target, source);
    }

    private boolean isBlocked(Map<Integer, Set<Integer>> blockMap, int[] target, int[] source) {
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target[0], new HashSet<>());
        visited.get(target[0]).add(target[1]);

        while (!queue.isEmpty()) {
            if (queue.size() > 2 * blockMap.size()) return false;
            int[] cur = queue.poll();
            if (Arrays.equals(cur, source)) return false;
            for (int[] p : POS) {
                int x = cur[0] + p[0], y = cur[1] + p[1];
                if (x >= 0 && y >= 0 && x < n && y < n && notInMap(blockMap, x, y) && notInMap(visited, x, y) ) {
                    queue.offer(new int[]{x, y});
                    visited.putIfAbsent(x, new HashSet<>());
                    visited.get(x).add(y);
                }
            }
        }
        return true;
    }

    private boolean notInMap(Map<Integer, Set<Integer>> map, int x, int y) {
        return !map.containsKey(x) || !map.get(x).contains(y);
    }

}
