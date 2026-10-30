import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private static final List<Integer> GOOD = new ArrayList<>();

    static {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a = 1; a <= 1000; ++a) {
            for (int b = a; b <= 1000; ++b) {
                int x = a * a * a + b * b * b;
                if (x > 1000000000) {
                    break;
                }
                cnt.merge(x, 1, Integer::sum);
            }
        }
        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            if (e.getValue() > 1) {
                GOOD.add(e.getKey());
            }
        }
        Collections.sort(GOOD);
    }

    public List<Integer> findGoodIntegers(int n) {
        int idx = Collections.binarySearch(GOOD, n + 1);
        if (idx < 0) {
            idx = -idx - 1;
        }
        return GOOD.subList(0, idx);
    }
}