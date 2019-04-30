class Solution {
    public String findLongestWord(String s, List<String> d) {
    	String res = "";
    	for (String cur : d) {
    		int i = 0, j = 0;
    		while (i < s.length() && j < cur.length()) {
    			if (s.charAt(i) == cur.charAt(j)) {
    				i++;
    				j++;
    			} else {
    				i++;
    			}
    		}
    		if (j == cur.length() && (cur.length() > res.length() || (cur.length() == res.length() && cur.compareTo(res) < 0)))
    			res = cur;
    		// print(res, cur);
    	}
    	return res;  
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
