class Solution {
    public String getPermutation(int n, int k) {
    	List<Integer> list = new ArrayList<>();
    	int fact = 1;
    	for (int i = 1; i <= n; i++) {
    		list.add(i);
    		fact *= i;
    	}
    	k--;
    	int tmp;
    	StringBuilder sb = new StringBuilder();
    	while (list.size() > 0) {
    		// print(fact, list.size());
    		fact /= n--;
    		tmp = k / fact;
    		sb.append(list.get(tmp));
    		list.remove(tmp);
    		k = k % fact;
    		// print(sb, list);
    	}
    	return sb.toString();
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
