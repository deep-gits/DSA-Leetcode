import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void backtrack(String num, int target, int index, long prevOperand, long currentVal, String currentExpression, List<String> result) {
        if (index == num.length()) {
            if (currentVal == target) {
                result.add(currentExpression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            String part = num.substring(index, i + 1);
            long currentOperand = Long.parseLong(part);

            if (index == 0) {
                backtrack(num, target, i + 1, currentOperand, currentOperand, part, result);
            } else {
                backtrack(num, target, i + 1, currentOperand, currentVal + currentOperand, currentExpression + "+" + part, result);
                backtrack(num, target, i + 1, -currentOperand, currentVal - currentOperand, currentExpression + "-" + part, result);
                backtrack(num, target, i + 1, prevOperand * currentOperand, currentVal - prevOperand + (prevOperand * currentOperand), currentExpression + "*" + part, result);
            }
        }
    }
}