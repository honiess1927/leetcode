class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>();
        for (String str : A) set.add(reArrange(str));
        return set.size();
    }

    public String reArrange(String s) {
    	List<Character> odd = new ArrayList<>();
    	List<Character> even = new ArrayList<>();
    	for (int i = 0; i < s.length(); i++) {
    		if (i % 2 == 0) even.add(s.charAt(i));
    		else odd.add(s.charAt(i));
    	}
    	Collections.sort(odd);
    	Collections.sort(even);
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < s.length(); i++) {
    		if (i % 2 == 0) sb.append(even.get(i / 2));
    		else sb.append(odd.get(i / 2));
    	}
    	return sb.toString();
    }
}
