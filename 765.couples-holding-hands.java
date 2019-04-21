class Solution {
    public int minSwapsCouples(int[] row) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = row.length;
        for (int i = 0; i < n; i++) {
        	map.put(row[i], i);
        }
        int res = 0;
        for (int i = 0; i < n; i+= 2) {
        	int me = row[i];
        	int lover = me % 2 == 0? me + 1 : me - 1;
        	int loverCurSeat = map.get(lover);
        	if (loverCurSeat == i + 1) continue;
        	int curNextToMe = row[i + 1];

        	row[loverCurSeat] = curNextToMe;
        	row[i + 1] = lover;
        	map.put(curNextToMe, loverCurSeat);
        	map.put(lover, i + 1);
        	res++;
        }
        return res;
    }

    private void print(int i) {
    	System.out.print(i + "   ");
    }
}
