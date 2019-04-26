/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l < r) {
        	int mid = l + (r - l) / 2;
        	int tmp = guess(mid);
        	// print(mid);
        	// print(tmp);
        	// print("    ");
        	if (tmp == 0) return mid;
        	if (tmp < 0) r = mid;
        	else l = mid + 1;
        }
        return l;
    }
    private void print(Object x) {System.out.print(x + " ");}
}
