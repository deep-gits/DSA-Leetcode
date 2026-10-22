import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int startIndex, int segmentCount, StringBuilder current, List<String> result) {
        if (segmentCount == 4 && startIndex == s.length()) {
            result.add(current.toString());
            return;
        }
        
        if (segmentCount == 4 || startIndex == s.length()) {
            return;
        }

        int len = current.length();
        for (int i = 1; i <= 3; i++) {
            if (startIndex + i > s.length()) {
                break;
            }
            
            String segment = s.substring(startIndex, startIndex + i);
            if ((segment.startsWith("0") && segment.length() > 1) || (i == 3 && Integer.parseInt(segment) > 255)) {
                continue;
            }

            if (segmentCount > 0) {
                current.append('.');
            }
            current.append(segment);

            backtrack(s, startIndex + i, segmentCount + 1, current, result);

            current.setLength(len);
        }
    }
}