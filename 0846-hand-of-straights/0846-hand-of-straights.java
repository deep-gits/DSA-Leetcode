import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }
        while (!map.isEmpty()) {
            int first = map.firstKey();
            int count = map.get(first);
            for (int i = 0; i < groupSize; i++) {
                int curr = first + i;
                if (!map.containsKey(curr)) {
                    return false;
                }
                int freq = map.get(curr);
                if (freq == count) {
                    map.remove(curr);
                } else if (freq > count) {
                    map.put(curr, freq - count);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}