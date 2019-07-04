class Solution {
    public boolean parseBoolExpr(String expression) {
        // print(expression);
        if (expression.equals("t")) {
            return true;
        }
        if (expression.equals("f")) {
            return false;
        }
        char op = expression.charAt(0);
        // left '(' == 1
        int start = 2;
        while (start < expression.length() - 1) {
            int cur = start;
            int left = 0;
            while (cur < expression.length() - 1) {
                if (expression.charAt(cur) == '(') {
                    left++;
                } else if (expression.charAt(cur) == ')') {
                    left--;
                }
                cur++;
                if ((expression.charAt(cur) == ',' && left == 0) || cur == expression.length() - 1) {
                    boolean next = parseBoolExpr(expression.substring(start, cur));
                    if (!next && op == '&') return false;
                    if (next && op == '|') return true;
                    if (op == '!') return !next;
                    start = ++cur;
                }
            }
        }
        return op == '&' ? true : false;
    }

    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
