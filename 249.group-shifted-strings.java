class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strings) {
        	String uni = generalize(s);
        	map.putIfAbsent(uni, new LinkedList<>());
        	map.get(uni).add(s);
        }
        return new LinkedList<>(map.values());
    }

    private String generalize(String s) {
    	int diff = s.charAt(0) - 'a';
    	StringBuilder sb = new StringBuilder();
    	for (char ch : s.toCharArray()) {
    		sb.append((char)(ch - diff < 'a' ? ch - diff + 26 : ch - diff));
    	}
    	return sb.toString();
    }
}
