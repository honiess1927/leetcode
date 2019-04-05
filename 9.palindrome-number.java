class Solution {
    public boolean isPalindrome(int x) {
    	if (x < 0) return false;
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
        	list.add(x % 10);
        	x = x / 10;
        }
        int l = 0, r = list.size() - 1;
        while (l < r) {
        	if (list.get(l) != list.get(r)) return false;
        	l++;
        	r--;
        }
        return true;
    }
}
