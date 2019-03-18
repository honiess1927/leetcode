class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	if (n == 1) return Arrays.asList(0);
        List<Set<Integer>> conns = new ArrayList<Set<Integer>>();
        for (int i = 0; i < n; i++) conns.add(new HashSet<>());
        for (int[] edge : edges) {
        	conns.get(edge[0]).add(edge[1]);
        	conns.get(edge[1]).add(edge[0]);
        }
        Set<Integer> leaves = new HashSet<>();
        for (int i = 0; i < conns.size(); i++) {
        	if (conns.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
        	n -= leaves.size();
        	Set<Integer> tmp = new HashSet<>();
        	for (Integer leaf : leaves) {
        		int next = conns.get(leaf).iterator().next();
        		conns.get(next).remove(leaf);
        		if (conns.get(next).size() == 1) tmp.add(next);
        	}
        	leaves = tmp;
        }

        return new LinkedList<Integer>(leaves);

    }
}
