class Solution {
	public boolean judgePoint24(int[] nums) {
		List<Double> list = new LinkedList<>();
		for (int num : nums) 
			list.add((double)num);
		return search(list);
	}

	private boolean search(List<Double> list) {
		// print(list);
		if (list.size() == 1) {
			return Math.abs(24 - Math.abs(list.get(0))) < 0.00001;
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				List<Double> tmp = new LinkedList<>();
				for (int p = 0; p < list.size(); p++) {
					if (p != i && p != j) tmp.add(list.get(p));
				}
				if (search(getNewList(tmp, list.get(i) + list.get(j)))) return true;
				if (search(getNewList(tmp, list.get(i) - list.get(j)))) return true;
				if (search(getNewList(tmp, list.get(j) - list.get(i)))) return true;
				if (search(getNewList(tmp, list.get(j) * list.get(i)))) return true;
				if (search(getNewList(tmp, list.get(j) / list.get(i)))) return true;
				if (search(getNewList(tmp, list.get(i) / list.get(j)))) return true;
			}
		}
		return false;
	}

	private List<Double> getNewList(List<Double> template, double newValue) {
		List<Double> newList = new LinkedList(template);
		newList.add(newValue);
		return newList;
	}
	private void print(Object... xs) { for (Object x : xs) { if (x.getClass().isArray()) { System.out.print(Arrays.toString((int[])x) + " "); } else { System.out.print(x + " "); } } System.out.print(" ");}
}
