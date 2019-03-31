class Solution {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
    	//Email to index
		HashMap<String, Integer> map = new HashMap<>();
		//Quick Find
		List<String> names = new ArrayList<>();
		List<TreeSet<String>> allEmails = new ArrayList<>();
		for (int k = 0; k < accounts.size(); k++) {
			List<String> account = accounts.get(k);
			TreeSet<String> myEmail = new TreeSet<>();
			for (int i = 1; i < account.size(); i++) {
				String email = account.get(i);
				if (map.containsKey(email) && map.get(email) != k) {
					int anotherAccount = map.get(email);
					//union
					Set<String> toUnion = allEmails.get(anotherAccount);
					for (String anotherEmail : toUnion) {
						myEmail.add(anotherEmail);
						map.put(anotherEmail, k);
					}
					allEmails.get(anotherAccount).clear();
				} else {
					myEmail.add(email);
					map.put(email, k);
				}
			}
			names.add(account.get(0));
			allEmails.add(myEmail);
		}
		List<List<String>> res = new LinkedList<>();
		for (int i = 0; i < allEmails.size(); i++) {
			Set<String> emailList = allEmails.get(i);
			if (!emailList.isEmpty()) {
				List<String> temp = new LinkedList<>();
				temp.add(names.get(i));
				temp.addAll(emailList);
				res.add(temp);
			}
		}
		return res;
	}
}
