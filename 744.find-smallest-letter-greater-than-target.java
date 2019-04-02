class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char min = (char)((int)target + 25);
        for (char ch : letters) {
        	if ((ch - target + 25) % 26 < (min - target + 25) % 26) min = ch;
        }
        return min;
    }
}
