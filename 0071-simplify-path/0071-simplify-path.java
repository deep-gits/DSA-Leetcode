class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] components = path.split("/");
        
        for (String comp : components) {
            if (comp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!comp.equals(".") && !comp.isEmpty()) {
                stack.push(comp);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        return result.length() > 0 ? result.toString() : "/";
    }
}