class Solution {
    public int oddEvenJumps(int[] A) {
        int n = A.length;
        boolean[] odd = new boolean[n], even = new boolean[n];
        odd[n - 1] = true;
        even[n - 1] = true;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(A[n-1], n-1);
        int res = 1;
        for (int i = n - 2; i >= 0; i--) {
            // print(A[i]);
            Map.Entry<Integer, Integer> entry = treeMap.ceilingEntry(A[i]);
            odd[i] = entry == null ? false : even[entry.getValue()];
            // if (entry != null) print("ceilingEntry: ", entry.getKey());

            entry = treeMap.floorEntry(A[i]);
            even[i] = entry == null ? false: odd[entry.getValue()];
            // if (entry != null) print("floorEntry: ", entry.getKey());

            if (odd[i]) res++;
            treeMap.put(A[i], i);
        }
        // System.out.print(Arrays.toString((boolean[])odd) + " ");
        // System.out.print(Arrays.toString((boolean[])even) + " ");
        return res;
    }
    private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
