class Solution {
    public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        int i = 0, j = 0;
        while (true) {
            while (i < start.length() && start.charAt(i) == 'X') i++;
            while (j < end.length() && end.charAt(j) == 'X') j++;
            if (i == start.length() || j == end.length()) break;
            if (start.charAt(i) != end.charAt(j)) return false;
            if (start.charAt(i) == 'L') {
                if (j > i) return false;
            } else if (j < i) return false;
            i++;
            j++;
        }
        return i == start.length() && j == end.length();
    }
}
