class Solution {
    public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');

        int r = num.length() - 1;
        for (int l = 0; l <= r; l++) {
        	if (map.getOrDefault(num.charAt(l), 'x') != num.charAt(r)) return false;
        	r--;
        }
        return true;
    }
}
