class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < s.length() - 1; i++) {
        	if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
        		StringBuilder sb = new StringBuilder();
        		sb.append(s.substring(0, i)).append("--").append(s.substring(i + 2));
        		res.add(sb.toString());
        	}
        }
        return res;
    }
}
