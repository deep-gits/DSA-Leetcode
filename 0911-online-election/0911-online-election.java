class TopVotedCandidate {
    private int[] leaders;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];
        Map<Integer, Integer> countMap = new HashMap<>();
        int lead = -1;
        int maxVotes = 0;

        for (int i = 0; i < persons.length; i++) {
            int p = persons[i];
            countMap.put(p, countMap.getOrDefault(p, 0) + 1);
            int votes = countMap.get(p);
            if (votes >= maxVotes) {
                maxVotes = votes;
                lead = p;
            }
            leaders[i] = lead;
        }
    }
    
    public int q(int t) {
        int idx = Arrays.binarySearch(times, t);
        if (idx < 0) {
            idx = -idx - 2;
        }
        return leaders[idx];
    }
}