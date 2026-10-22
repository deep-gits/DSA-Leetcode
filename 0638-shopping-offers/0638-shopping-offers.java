import java.util.List;
import java.util.Map;
import java.util.HashMap;

class Solution {
    private Map<String, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dp(price, special, needs);
    }

    private int dp(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        String key = needs.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int minCost = directPurchase(price, needs);

        for (List<Integer> s : special) {
            List<Integer> nextNeeds = new java.util.ArrayList<>(needs);
            boolean isValid = true;
            for (int i = 0; i < needs.size(); i++) {
                int diff = nextNeeds.get(i) - s.get(i);
                if (diff < 0) {
                    isValid = false;
                    break;
                }
                nextNeeds.set(i, diff);
            }

            if (isValid) {
                minCost = Math.min(minCost, s.get(s.size() - 1) + dp(price, special, nextNeeds));
            }
        }

        memo.put(key, minCost);
        return minCost;
    }

    private int directPurchase(List<Integer> price, List<Integer> needs) {
        int total = 0;
        for (int i = 0; i < needs.size(); i++) {
            total += needs.get(i) * price.get(i);
        }
        return total;
    }
}