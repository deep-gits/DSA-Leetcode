import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minStickers(String[] stickers, String target) {
        int m = target.length();
        int[] targetCounts = new int[26];
        for (char c : target.toCharArray()) {
            targetCounts[c - 'a']++;
        }

        int[][] stickerCounts = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                stickerCounts[i][c - 'a']++;
            }
        }

        Map<String, Integer> memo = new HashMap<>();
        memo.put("", 0);

        return dp(targetCounts, stickerCounts, memo);
    }

    private int dp(int[] targetCounts, int[][] stickerCounts, Map<String, Integer> memo) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (targetCounts[i] > 0) {
                sb.append((char) ('a' + i)).append(targetCounts[i]);
            }
        }
        String key = sb.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int ans = Integer.MAX_VALUE;
        int firstChar = -1;
        for (int i = 0; i < 26; i++) {
            if (targetCounts[i] > 0) {
                firstChar = i;
                break;
            }
        }

        for (int[] sticker : stickerCounts) {
            if (sticker[firstChar] == 0) {
                continue;
            }

            int[] nextTargetCounts = targetCounts.clone();
            for (int i = 0; i < 26; i++) {
                nextTargetCounts[i] = Math.max(0, nextTargetCounts[i] - sticker[i]);
            }

            int res = dp(nextTargetCounts, stickerCounts, memo);
            if (res != -1) {
                ans = Math.min(ans, 1 + res);
            }
        }

        int result = (ans == Integer.MAX_VALUE) ? -1 : ans;
        memo.put(key, result);
        return result;
    }
}