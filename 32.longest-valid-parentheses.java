class Solution {
    public int longestValidParentheses(String s) {
        char[] ss = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ss.length; i++) {
        	if (ss[i] == ')' && !stack.isEmpty() && ss[stack.peek()] == '(') stack.pop(); 
        	else stack.push(i);
        }
        int end = ss.length;
        int res = 0;
        while (!stack.isEmpty()) {
        	int start = stack.pop();
        	res = Math.max(res, end - start - 1);
        	end = start;
        }
        res = Math.max(res, end);
        return res;
    }
}
