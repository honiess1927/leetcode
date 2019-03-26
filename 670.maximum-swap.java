class Solution {
	public int maximumSwap(int num) {
		List<Integer> list = new ArrayList<>();
		do {
			list.add(num % 10);
			num = num / 10;
		} while (num != 0);
		Collections.reverse(list);
		// System.out.println(list);

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < list.size(); i++) {
			while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
				stack.pop();
			}
			stack.push(i);
		}

		List<Integer> list2 = new ArrayList(stack);
		// System.out.println(list2);
		int i = 0;
		for (; i < list2.size(); i++) {
			if (list2.get(i) != i) {
				int numToSwap = list.get(list2.get(i));
				int toIndex = i;
				while (i < list2.size() && list.get(list2.get(i)) == numToSwap) {
					i++;
				}
				i--;
				int fromIndex = list2.get(i);
				// System.out.println(fromIndex + ":" + toIndex);
				int swap = list.get(toIndex);
				list.set(toIndex, list.get(fromIndex));
				list.set(fromIndex, swap);
				// System.out.println(list);
				break;
			}
		}
		int res = 0;
		for (int a : list) {
			res = res * 10 + a;
		}
		return res;
	}
}
