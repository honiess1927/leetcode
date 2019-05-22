class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<>(), y = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    x.add(i);
                    y.add(j);
                }
            }
        }
        return getDist(x) + getDist(y);
    }

    private int getDist(List<Integer> list) {
        Collections.sort(list);
        int median = list.get(list.size() / 2), res = 0;
        for (int x : list) {
            res += Math.abs(median - x);
        }
        return res;
    }
}
