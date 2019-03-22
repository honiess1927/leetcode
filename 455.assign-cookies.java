class Solution {
    public int findContentChildren(int[] children, int[] cookie) {
        Arrays.sort(children);
        Arrays.sort(cookie);
        int i = 0, j = 0, res = 0;
        while (j < cookie.length && i < children.length) {
        	while (j < cookie.length && cookie[j] < children[i]) {
        		j++;
        	}
        	if (j < cookie.length) {
        		res++;
        		i++;
        		j++;
        	}
        }
        return res;
    }
}
