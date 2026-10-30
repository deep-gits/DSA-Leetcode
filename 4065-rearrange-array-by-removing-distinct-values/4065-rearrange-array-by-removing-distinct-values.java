import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> res = new ArrayList<>();
        while (!map.isEmpty()) {
            List<Integer> keysToDecrement = new ArrayList<>(map.keySet());
            for (int key : keysToDecrement) {
                res.add(key);
                int count = map.get(key);
                if (count == 1) {
                    map.remove(key);
                } else {
                    map.put(key, count - 1);
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}