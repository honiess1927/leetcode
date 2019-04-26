class Solution {
	private class Node {
		Node[] nodes;
		Node() {
			nodes = new Node[2];
		}
		boolean hasNode(int i) {
			return nodes[i] != null;
		}
		Node getOrCreate(int i) {
			if (!hasNode(i)) nodes[i] = new Node();
			return nodes[i];
		}
	}
	public int findMaximumXOR(int[] nums) {
		Node root = new Node();
		for (int num : nums) {
			int mask = (1 << 30);
			Node cur = root;
			for (int i = 0; i < 31; i++) {
				int bit = (num & mask) == 0 ? 0 : 1;
				// print(bit);
				cur = cur.getOrCreate(bit);
				mask = mask >> 1;
			}
		}
		// print("             ");
		int max = 0;
		for (int num : nums) {
			Node cur = root;
			int tmp = 0;
			int mask = (1 << 30);
			for (int i = 0; i < 31; i++) {
				int bit = (num & mask) == 0 ? 0 : 1;
				// print(bit);
				if (cur.hasNode(1 - bit)) {
					tmp = tmp | mask;
					cur = cur.getOrCreate(1 - bit);
				} else {
					cur = cur.getOrCreate(bit);
				}
				mask = mask >> 1;
			}
			max = Math.max(tmp, max);
		}
		return max;
	}
	private void print(Object x) {System.out.print(x + " ");}
}
