import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for (String s : allowed) {
            String key = s.substring(0, 2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s.charAt(2));
        }
        return dfs(bottom, map, new HashMap<>());
    }

    private boolean dfs(String row, Map<String, List<Character>> map, Map<String, Boolean> memo) {
        if (row.length() == 1) {
            return true;
        }
        if (memo.containsKey(row)) {
            return memo.get(row);
        }

        List<String> nextRows = new ArrayList<>();
        generateNextRows(row, 0, new StringBuilder(), map, nextRows);

        for (String nextRow : nextRows) {
            if (dfs(nextRow, map, memo)) {
                memo.put(row, true);
                return true;
            }
        }

        memo.put(row, false);
        return false;
    }

    private void generateNextRows(String row, int index, StringBuilder current, Map<String, List<Character>> map, List<String> nextRows) {
        if (index == row.length() - 1) {
            nextRows.add(current.toString());
            return;
        }

        String key = row.substring(index, index + 2);
        List<Character> list = map.get(key);
        if (list == null) {
            return;
        }

        for (char c : list) {
            current.append(c);
            generateNextRows(row, index + 1, current, map, nextRows);
            current.deleteCharAt(current.length() - 1);
        }
    }
}