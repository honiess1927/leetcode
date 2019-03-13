class Solution {
    public int calPoints(String[] ops) {
       Stack<Integer> stack = new Stack<>();
       for (String s : ops) {
         switch(s) {
           case "C":
             stack.pop();
             break;
           case "D":
             stack.push(stack.peek() * 2);
             break;
          case "+":
             int cur = stack.pop();
             int next = cur + stack.peek();
             stack.push(cur);
             stack.push(next);
             break;
          default:
             stack.push(Integer.parseInt(s));
         }
       }
       int res = 0;
       while (!stack.isEmpty()) res += stack.pop();
       return res;
    }
}
