class Solution {
	public boolean isRobotBounded(String instructions) {
		final int[][] POS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
		int x = 0, y = 0, facing = 0;
		for (char ch : instructions.toCharArray()) {
			switch(ch) {
				case 'G': x += POS[facing][0];
				y += POS[facing][1];
				break;
				case 'R': facing = (facing + 1) % 4;
				break;
				case 'L': facing = (facing + 3) % 4;
				break;
			}
		}
		return (x == 0 && y == 0) || facing != 0;
	}
}
