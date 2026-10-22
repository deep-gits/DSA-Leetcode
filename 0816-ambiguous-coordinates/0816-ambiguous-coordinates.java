import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        String num = s.substring(1, s.length() - 1);
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i < num.length(); i++) {
            List<String> left = make(num.substring(0, i));
            List<String> right = make(num.substring(i));
            
            for (String l : left) {
                for (String r : right) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }
        
        return result;
    }

    private List<String> make(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        
        for (int i = 1; i <= n; i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);
            
            if ((left.length() > 1 && left.startsWith("0")) || (right.length() > 0 && right.endsWith("0"))) {
                continue;
            }
            
            if (right.length() > 0) {
                res.add(left + "." + right);
            } else {
                res.add(left);
            }
        }
        
        return res;
    }
}