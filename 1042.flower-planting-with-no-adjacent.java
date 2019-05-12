class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
    	Map<Integer, Set<Integer>> map = new HashMap<>();
    	for (int i = 1; i <= N; i++) map.put(i, new HashSet<>());
    	for (int[] path : paths) {
    		map.get(path[0]).add(path[1]);
    		map.get(path[1]).add(path[0]);
    	}
        int[] res = new int[N];
        for (int i = 1; i <= N; i++) {
        	Set<Integer> set = map.get(i);
        	boolean[] flag = new boolean[5];
        	for (int connected : set) {
        		flag[res[connected - 1]] = true;
        	}
        	for (int j = 1; j <= 4; j++) {
        		if (!flag[j]) {
        			res[i - 1] = j;
        			break;
        		}
        	}
        }
        return res;
    }
}
