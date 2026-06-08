class Solution {
    public boolean containsDuplicate(int[] nums) {
         Set set = new HashSet<>();
        for (int n : nums) {
            if (!set.add(n)) return true;
        }
        return false;
        
    }
}