class Solution {
	public boolean lemonadeChange(int[] bills) {
		int[] money = new int[2];
		for (int bill : bills) {
			switch(bill) {
				case 5: 
					money[0]++;
					break;
				case 10: 
					if (money[0] < 1) return false;
					money[1]++;
					money[0]--;
				break;
				case 20: 
					if (money[1] > 0 && money[0] > 0) {
						money[1]--;
            money[0]--;
					} else if (money[0] >= 3) {
						money[0] -= 3;
					} else return false;
			}
		}
		return true;
	}
}
