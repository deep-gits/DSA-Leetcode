import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<String>> wordSquares(String[] words) {
        Arrays.sort(words);
        int n = words.length;
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String top = words[i];
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                String left = words[j];
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    String right = words[k];
                    for (int h = 0; h < n; h++) {
                        if (h == i || h == j || h == k) {
                            continue;
                        }
                        String bottom = words[h];
                        if (top.charAt(0) == left.charAt(0) && top.charAt(3) == right.charAt(0) &&
                            bottom.charAt(0) == left.charAt(3) && bottom.charAt(3) == right.charAt(3)) {
                            ans.add(List.of(top, left, right, bottom));
                        }
                    }
                }
            }
        }
        return ans;
    }
}