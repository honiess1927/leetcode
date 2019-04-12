class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for (int[] update : updates) {
        	res[update[0]] += update[2];
        	if (update[1] < length - 1) 
        		res[update[1] + 1] -= update[2];
        }
        int addition = 0;
        for (int i = 0; i < length; i++) {
        	addition += res[i];
        	res[i] = addition;
        }
        return res;
    }
}
