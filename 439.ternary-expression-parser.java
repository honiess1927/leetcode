class Solution {
    public String parseTernary(String expression) {
    	if (expression.length() <= 1) return expression;
        boolean left = expression.charAt(0) == 'T';
        int cnt = 0, i = 1;
        do {
        	char ch = expression.charAt(i++);
        	if (ch == '?') cnt++;
        	else if (ch == ':') cnt--;
        } while (cnt != 0);
        if (left) return parseTernary(expression.substring(2, i - 1));
        	else return parseTernary(expression.substring(i));
    }
}
