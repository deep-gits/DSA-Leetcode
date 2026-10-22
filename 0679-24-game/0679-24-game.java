import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int c : cards) {
            list.add((double) c);
        }
        return solve(list);
    }

    private boolean solve(List<Double> list) {
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < EPSILON;
        }

        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                List<Double> nextList = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        nextList.add(list.get(k));
                    }
                }

                double a = list.get(i);
                double b = list.get(j);

                List<Double> results = compute(a, b);
                for (double res : results) {
                    nextList.add(res);
                    if (solve(nextList)) {
                        return true;
                    }
                    nextList.remove(nextList.size() - 1);
                }
            }
        }

        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPSILON) {
            res.add(a / b);
        }
        if (Math.abs(a) > EPSILON) {
            res.add(b / a);
        }
        return res;
    }
}