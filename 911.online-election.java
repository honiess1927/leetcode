class TopVotedCandidate {
	TreeMap<Integer, Integer> winner;
    public TopVotedCandidate(int[] persons, int[] times) {
        winner = new TreeMap<>();
        int maxVote = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < persons.length; i++) {
        	map.put(persons[i], map.getOrDefault(persons[i], 0) + 1);
        	if (map.get(persons[i]) >= maxVote) {
        		maxVote = map.get(persons[i]);
        		winner.put(times[i], persons[i]);
        	}
        }
    }
    
    public int q(int t) {
        return winner.floorEntry(t).getValue();
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */
