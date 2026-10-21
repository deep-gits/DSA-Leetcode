class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        
        for (List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }
        
        LinkedList<String> result = new LinkedList<>();
        dfs("JFK", map, result);
        return result;
    }
    
    private void dfs(String curr, Map<String, PriorityQueue<String>> map, LinkedList<String> result) {
        PriorityQueue<String> neighbors = map.get(curr);
        
        while (neighbors != null && !neighbors.isEmpty()) {
            dfs(neighbors.poll(), map, result);
        }
        
        result.addFirst(curr);
    }
}