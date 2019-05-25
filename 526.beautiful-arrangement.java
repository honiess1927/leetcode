class Solution {
    public int countArrangement(int N) {
        return dfs(new boolean[N + 1], 1);
    }

    public int dfs(boolean[] visited, int index) {
        if (index == visited.length) {
            return 1;
        }
        int res = 0;
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i] && (i % index == 0 || index % i == 0)) {
                visited[i] = true;
                res += dfs(visited, index + 1);
                visited[i] = false;
            }
        }
        return res;
    }
}
