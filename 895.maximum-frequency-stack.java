class FreqStack {
    Map<Integer, Integer> map;
    Map<Integer, Stack<Integer>> smap;
    int maxFreq;
    public FreqStack() {
        map = new HashMap<>();
        smap = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int x) {
        int freq = map.getOrDefault(x, 0) + 1;
        map.put(x, freq);
        maxFreq = Math.max(freq, maxFreq);
        if (!smap.containsKey(freq)) smap.put(freq, new Stack<>());
        smap.get(freq).push(x);
    }
    
    public int pop() {
       int res = smap.get(maxFreq).pop();
       map.put(res, map.get(res) - 1);
       while (maxFreq > 0) {
          if (!smap.containsKey(maxFreq) || smap.get(maxFreq).isEmpty()) maxFreq--;
          else break;
       }
       return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */
