class Solution {
	public List<List<String>> partition(String s) {
		List<List<String>> res = new LinkedList<>();
		helper(s, res, new LinkedList<>());
		return res;
	}

	public void helper (String s, List<List<String>> res, List<String> cur) {
		if (s.isEmpty()) {
			if (!cur.isEmpty()) {
				res.add(copy(cur));
			}
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s, i)) {
				cur.add(s.substring(0, i + 1));
				helper(s.substring(i + 1), res, cur);
				cur.remove(cur.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int end) {
		int l = 0, r = end;
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) return false;
			l++;
			r--;
		}
		return true;
	}

	private List<String> copy(List<String> original) {
		List<String> replica = new LinkedList<>();
		for (String s : original) 
			replica.add(s);
		return replica;
	}
}
