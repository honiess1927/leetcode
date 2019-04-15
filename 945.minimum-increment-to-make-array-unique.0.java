class Solution {
    public int minIncrementForUnique(int[] A) {
    	TreeSet<Integer> set = new TreeSet<>();
    	set.add(0);
    	int[] f = new int[80001];
    	for (int num : A) {
    		f[num]++;
    		if (set.contains(num)) set.remove(num);
    		if (f[num + 1] == 0) set.add(num + 1);
    	}
    	int res = 0;
        for (int num : A) {
        	if (f[num] == 1) continue;
        	int next = set.higher(num);
        	res += next - num;
        	f[num]--;
        	f[next]++;
        	set.remove(next);
        	if (f[next + 1] == 0) {
        		set.add(next + 1);
        	}
        }
        return res;
    }
}
