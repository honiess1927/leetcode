class Solution {
	public String reverseVowels(String s) {
		char[] vowels = new char[]{'a','A','e','E','i','I','o','O','u','U'};
		Set<Character> vowelSet = new HashSet<>();
		for (char ch : vowels ) 
			vowelSet.add(ch);
		int i = 0, j = s.length() - 1;
		char[] ss = s.toCharArray();
		while (i < j) {
			while (i < j && !vowelSet.contains(ss[i])) i++;
			while (i < j && !vowelSet.contains(ss[j])) j--;
			if (i < j) {
				char swap = ss[i];
				ss[i] = ss[j];
				ss[j] = swap;
				i++;
				j--;
			}
		}
		return new String(ss);
	}
}
