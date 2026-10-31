class Solution {
    public String winningPlayer(int x, int y) {
        int turns = Math.min(x, y / 4);
        return turns % 2 == 1 ? "Alice" : "Bob";
    }
}