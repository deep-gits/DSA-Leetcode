class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> stack =
                new Stack<>();

        for (String token : tokens) {

            switch (token) {

                case "+":
                    stack.push(
                        stack.pop() + stack.pop());
                    break;

                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;

                case "*":
                    stack.push(
                        stack.pop() * stack.pop());
                    break;

                case "/":
                    int d = stack.pop();
                    int c = stack.pop();
                    stack.push(c / d);
                    break;

                default:
                    stack.push(
                        Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}