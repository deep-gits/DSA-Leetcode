class Solution {
    private Map<Integer, List<Integer>> map;
    private Random rand;

    public Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> indices = map.get(target);
        return indices.get(rand.nextInt(indices.size()));
    }
}