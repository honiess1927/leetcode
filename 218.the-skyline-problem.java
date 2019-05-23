class Solution {
    private class Edge implements Comparable<Edge> {
        int pos, height;
        boolean isStart;
        Edge(int pos, int height, boolean isStart) {
            this.pos = pos;
            this.height = height;
            this.isStart = isStart;
        }
        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.pos, other.pos);
        }
        @Override
        public String toString() {
            return "" + pos + "," + height;
        }
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Edge> edges = new ArrayList<>();
        for (int[] building : buildings) {
            edges.add(new Edge(building[0], building[2], true));
            edges.add(new Edge(building[1], building[2], false));
        }
        Collections.sort(edges);
        // print(edges);
        PriorityQueue<Integer> heights = new PriorityQueue<>(Collections.reverseOrder());
        int preHeight = -1;
        List<List<Integer>> res = new LinkedList<>();
        int i = 0;
        while (i < edges.size()) {
            Edge edge;
            do {
                edge = edges.get(i);
                if (edge.isStart) {
                    heights.offer(edge.height);
                } else {
                    heights.remove(edge.height);
                }
                i++;
            } while (i < edges.size() && edges.get(i).pos == edge.pos);
            int curHeight = heights.isEmpty() ? 0 : heights.peek();
            if (curHeight != preHeight) {
                List<Integer> list = new LinkedList<>();
                list.add(edge.pos);
                list.add(curHeight);
                res.add(list);
                preHeight = curHeight;
            }
            // print(heights);
        }
        return res;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
