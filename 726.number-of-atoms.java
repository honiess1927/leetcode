class Solution {
  public String countOfAtoms(String formula) {
    Stack<Map<String, Integer>> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    Map<String, Integer> map = new HashMap<>();
    int count = 0;
    for (char ch : formula.toCharArray()) {
      if (ch >= 97) sb.append(ch);
      else if (ch >= '0' && ch <= '9') {
        count = count * 10 + (ch - '0');
      } else {
        if (sb.length() != 0) {
          String atom = sb.toString();
          // System.out.println(atom + ":" + count);
          map.put(atom, map.getOrDefault(atom, 0) + (count == 0? 1 : count));
          // System.out.println(map);
          sb = new StringBuilder();
          count = 0;
        } else if (count != 0 && !stack.isEmpty()) {
          Map<String, Integer> prevMap = stack.pop();
          for (Map.Entry<String, Integer> entry : map.entrySet()) {
            prevMap.put(entry.getKey(), prevMap.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
            map = prevMap;
          }
          count = 0;
        }
        if (ch == '(') {
          stack.push(map);
          map = new HashMap<>();
        } else if (ch != ')') {
          sb.append(ch);
        }
      }
    }
    // System.out.println(stack.size());
    // System.out.println(count);  
    // System.out.println(map);
    if (sb.length() != 0) {
      String atom = sb.toString();
      map.put(atom, map.getOrDefault(atom, 0) + (count == 0? 1 : count));
      sb = new StringBuilder();
      count = 0;
    } else if (!stack.isEmpty()) {
      Map<String, Integer> prevMap = stack.pop();
      for (Map.Entry<String, Integer> entry : map.entrySet()) {
        prevMap.put(entry.getKey(), prevMap.getOrDefault(entry.getKey(), 0) + entry.getValue() * count);
        map = prevMap;
      }
    }
    List<Map.Entry<String, Integer>> entryList = new ArrayList(map.entrySet());
    Collections.sort(entryList, (a, b) -> (a.getKey().compareTo(b.getKey())));
    for (Map.Entry<String, Integer> entry : entryList) {
      sb.append(entry.getKey());
      if (entry.getValue() != 1) sb.append(entry.getValue());
    }
    return sb.toString();
  }
}

