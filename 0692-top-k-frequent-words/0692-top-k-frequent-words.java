class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }
        
        // Min-heap to keep the top k frequent words. 
        // If frequencies are equal, we want the lexicographically larger word at the top
        // so it gets evicted in favor of the lexicographically smaller word.
        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA == freqB) {
                return b.compareTo(a); // Reverse alphabetical order for max-lexicographical at top
            }
            return Integer.compare(freqA, freqB);
        });
        
        for (String word : freqMap.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        
        // Since it's a min-heap, elements come out least frequent/lexicographically largest first.
        // Reverse to get highest frequency and lexicographical order first.
        Collections.reverse(result);
        return result;
    }
}