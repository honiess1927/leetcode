class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0) return res;
        helper(res, n, n, new StringBuilder());
        return res;
    }

    private void helper(List<String> res, int left, int right, StringBuilder sb) {
    	if (left == 0 && right == 0) {
    		res.add(sb.toString());
    		return;
    	}
    	if (left > 0) {
    		sb.append('(');
    		helper(res, left - 1, right, sb);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    	if (right > left)  {
    		sb.append(')');
    		helper(res, left, right - 1, sb);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    }
}
